package net.kasp416h.warcraft.entity.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class StormwindGuardModel<T extends LivingEntity> extends HumanoidModel<T> {
	public StormwindGuardModel(ModelPart modelPart) {
		super(modelPart);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

		if (entity.isBlocking()) {
			this.leftArm.xRot = -0.75F;
			this.leftArm.yRot = 0.0F;
			this.leftArm.zRot = 0.5F;
		}
	}
}