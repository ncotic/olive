package com.abwfl.olive.registers;

import com.abwfl.olive.Olive;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class SoundEventsRegister {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Olive.MOD_ID);

    public static final Supplier<SoundEvent> SPAWN_SOUND =
            SOUND_EVENTS.register("entity.olive.spawn", registryName -> SoundEvent.createFixedRangeEvent(registryName, 32f));

    public static final Supplier<SoundEvent> CATCH_SOUND =
            SOUND_EVENTS.register("entity.olive.catch", registryName -> SoundEvent.createFixedRangeEvent(registryName, 32f));
}
