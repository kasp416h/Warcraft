package net.kasp416h.warcraft.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.kasp416h.warcraft.Warcraft;
import net.kasp416h.warcraft.entity.custom.OrcEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OrcRenderer
        extends MobRenderer<OrcEntity, OrcModel<OrcEntity>> {
    public OrcRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OrcModel<>(pContext.bakeLayer(ModModelLayers.ORC_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(OrcEntity pEntity) {
        return new ResourceLocation(Warcraft.MODID, "textures/entity/orc.png");
    }

    @Override
    public void render(OrcEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
            MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}