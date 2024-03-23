package net.kasp416h.warcraft.entity.client;

import net.kasp416h.warcraft.Warcraft;
import net.minecraft.client.model.geom.ModelLayers;
import net.kasp416h.warcraft.entity.custom.StormwindGuardEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StormwindGuardRenderer
        extends HumanoidMobRenderer<StormwindGuardEntity, StormwindGuardModel<StormwindGuardEntity>> {
    public StormwindGuardRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new StormwindGuardModel<>(pContext.bakeLayer(ModelLayers.PLAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(StormwindGuardEntity pEntity) {
        return new ResourceLocation(Warcraft.MODID, "textures/entity/stormwind_guard.png");
    }
}