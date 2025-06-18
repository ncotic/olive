package com.abwfl.olive.registers;

import com.abwfl.olive.Olive;
import com.abwfl.olive.entity.custom.OliveEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EntityTypesRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Olive.MOD_ID);

    public static ResourceKey<EntityType<?>> OLIVE_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("olive"));

    public static final Supplier<EntityType<OliveEntity>> OLIVE =
            ENTITY_TYPES.register("olive", () -> EntityType.Builder.of(OliveEntity::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .noSummon()
                    .build(OLIVE_KEY));
}
