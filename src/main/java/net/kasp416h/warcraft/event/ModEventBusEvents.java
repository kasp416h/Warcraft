package net.kasp416h.warcraft.event;

import net.kasp416h.warcraft.Warcraft;
import net.kasp416h.warcraft.entity.ModEntities;
import net.kasp416h.warcraft.entity.custom.StormwindGuardEntity;
import net.kasp416h.warcraft.entity.custom.OrcEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Warcraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.STORMWIND_GUARD.get(), StormwindGuardEntity.createAttributes().build());
        event.put(ModEntities.ORC.get(), OrcEntity.createAttributes().build());
    }
}
