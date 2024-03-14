package net.kasp416h.warcraft.entity;

import net.kasp416h.warcraft.Warcraft;
import net.kasp416h.warcraft.entity.custom.StormwindGuardEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister
            .create(ForgeRegistries.ENTITY_TYPES, Warcraft.MODID);

    public static final RegistryObject<EntityType<StormwindGuardEntity>> STORMWIND_GUARD = ENTITY_TYPES
            .register("stormwind_guard", () -> EntityType.Builder.of(StormwindGuardEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.95F).build("stormwind_guard"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}