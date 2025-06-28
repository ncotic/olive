package com.abwfl.olive.networking;

import com.abwfl.olive.Olive;
import com.abwfl.olive.registers.SoundEventsRegister;
import com.abwfl.olive.screens.CubeMapScreen;
import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.Objects;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class ClientPayloadHandler {
    public static void handleDataOnMain(final OlivePacket data, final IPayloadContext context) {
        if (Objects.equals(data.uuid(), context.player().getStringUUID())) {
            try {
                Minecraft instance = Minecraft.getInstance();
                Olive.useCustomMessage = true;
                Function<ResourceLocation, TextureAtlasSprite> atlasGetter = Minecraft.getInstance().getTextureAtlas(ResourceLocation.withDefaultNamespace("textures/atlas/blocks.png"));
                instance.setScreen(new CubeMapScreen(Olive.blockTextureIds, atlasGetter));
                instance.getSoundManager().stop();
                context.player().playSound(SoundEventsRegister.CATCH_SOUND.get());
                Thread.sleep(200);
                instance.getSoundManager().destroy();
                instance.getWindow().setTitle(context.player().getStringUUID() + " PLAYER DISCONNECT ERROR");
                new java.util.Timer().schedule(new java.util.TimerTask() {
                    @Override
                    public void run() {
                        instance.execute(() -> instance.delayCrashRaw(new CrashReport("Unknown error", new Throwable("INTERLOPE"))));
                    }
                }, 6584);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}