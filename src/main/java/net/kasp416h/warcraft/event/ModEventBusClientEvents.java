package net.kasp416h.warcraft.event;

import net.kasp416h.warcraft.Warcraft;
import net.kasp416h.warcraft.entity.client.ModModelLayers;
import net.kasp416h.warcraft.entity.client.StormwindGuardModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Warcraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
}