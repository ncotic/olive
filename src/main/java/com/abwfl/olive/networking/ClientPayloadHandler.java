package com.abwfl.olive.networking;

import com.abwfl.olive.registers.SoundEventsRegister;
import net.minecraft.client.Minecraft;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.Objects;

public class ClientPayloadHandler {

    public static void handleDataOnMain(final OlivePacket data, final IPayloadContext context) {
        if (Objects.equals(data.uuid(), context.player().getStringUUID())) {
            try {
                Minecraft.getInstance().getSoundManager().stop();
                context.player().playSound(SoundEventsRegister.CATCH_SOUND.get());
                Thread.sleep(500);
                Minecraft.getInstance().stop();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}