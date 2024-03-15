package net.kasp416h.warcraft.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.kasp416h.warcraft.Warcraft;
import net.kasp416h.warcraft.entity.custom.StormwindGuardEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StormwindGuardRenderer
        extends MobRenderer<StormwindGuardEntity, StormwindGuardModel<StormwindGuardEntity>> {
    public StormwindGuardRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new StormwindGuardModel<>(pContext.bakeLayer(ModModelLayers.STORMWIND_GUARD_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(StormwindGuardEntity pEntity) {
        return new ResourceLocation(Warcraft.MODID, "textures/entity/stormwind_guard.png");
    }

    @Override
    public void render(StormwindGuardEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
            MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}