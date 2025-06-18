package com.abwfl.olive.events;

import com.abwfl.olive.Olive;
import com.abwfl.olive.entity.client.OliveModel;
import com.abwfl.olive.entity.custom.OliveEntity;
import com.abwfl.olive.networking.ClientPayloadHandler;
import com.abwfl.olive.networking.OlivePacket;
import com.abwfl.olive.registers.EntityTypesRegister;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = Olive.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(OliveModel.LAYER_LOCATION, OliveModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void newEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypesRegister.OLIVE.get(),
                OliveEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(
                OlivePacket.TYPE,
                OlivePacket.STREAM_CODEC,
                ClientPayloadHandler::handleDataOnMain
        );
    }
}
