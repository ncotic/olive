package com.abwfl.olive;

import com.abwfl.olive.commands.OliveCommand;
import com.abwfl.olive.entity.client.OliveRenderer;
import com.abwfl.olive.entity.custom.OliveEntity;
import com.abwfl.olive.entity.custom.OlivePlayerManager;
import com.abwfl.olive.registers.EntityTypesRegister;
import com.abwfl.olive.registers.SoundEventsRegister;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;

import java.util.*;

@Mod(Olive.MOD_ID)
public class Olive {
    public static final String MOD_ID = "olive";
    public static List<ResourceLocation> blockTextureIds = new ArrayList<>();
    public static boolean useCustomMessage = false;

    public Olive(IEventBus modEventBus, ModContainer modContainer) {
        EntityTypesRegister.ENTITY_TYPES.register(modEventBus);
        SoundEventsRegister.SOUND_EVENTS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(EntityTypesRegister.OLIVE.get(), OliveRenderer::new);
        }
    }

    @SubscribeEvent
    public void registerCommands(RegisterCommandsEvent event){
        OliveCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public void onLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        UUID playerId = event.getEntity().getUUID();
        ServerLevel level = (ServerLevel) event.getEntity().level();

        if (OlivePlayerManager.hasTracker(playerId)) {
            Entity tracker = level.getEntity(OlivePlayerManager.getEntityId(playerId));
            if (tracker instanceof OliveEntity trackEnt) {
                trackEnt.onTrackedPlayerLogout();
            }
        }
    }

    @SubscribeEvent
    public void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
        UUID playerId = event.getEntity().getUUID();
        ServerPlayer player = (ServerPlayer) event.getEntity();
        ServerLevel level = player.serverLevel();

        if (OlivePlayerManager.hasTracker(playerId)) {
            Entity tracker = level.getEntity(OlivePlayerManager.getEntityId(playerId));
            if (tracker instanceof OliveEntity trackEnt) {
                trackEnt.onTrackedPlayerLogin(player);
            }
        }
    }

    @SubscribeEvent
    public void onServerStopped(ServerStoppingEvent event) {
        MinecraftServer server = event.getServer();
        for (ServerLevel level : server.getAllLevels()) {
            level.getEntities(EntityType.byString("olive:olive").orElseThrow(), entity -> true)
                    .forEach(Entity::discard);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        for (ServerLevel level : server.getAllLevels()) {
            level.getEntities(EntityType.byString("olive:olive").orElseThrow(), entity -> true)
                    .forEach(Entity::discard);
        }
    }
}
