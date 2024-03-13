package net.kasp416h.warcraft.entity.custom;

import net.minecraft.world.entity.mobentity.MobEntity;

public class TestEntity extends MobEntity {
    public TestEntity(EntityType<? extends MobEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return MobEntity.createLivingAttributes()
            .add(Attributes.MAX_HEALTH, 200)
            .add(Attributes.MOVEMENT_SPEED, 0.25D)
            .add(Attributes.ARMOR_TOUGHNESS, 0.1f);
    }
}