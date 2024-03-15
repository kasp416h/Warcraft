package net.kasp416h.warcraft.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import org.jetbrains.annotations.Nullable;
import net.kasp416h.warcraft.entity.ai.goals.UseShieldIfTargetHasBowGoal;
import java.util.EnumSet;
import java.util.List;

public class StormwindGuardEntity extends Mob {
    private long lastAlertTime = 0;
    private static final long ALERT_COOLDOWN = 10000;

    public StormwindGuardEntity(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.equipWithIronSwordAndShield();
    }

    private void equipWithIronSwordAndShield() {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new UseShieldIfTargetHasBowGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new AlertOthersGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.VINDICATOR_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.VINDICATOR_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.VINDICATOR_DEATH;
    }

    private boolean isBlocking = false;

    public boolean isBlocking() {
        return isBlocking;
    }

    public void setBlocking(boolean blocking) {
        this.isBlocking = blocking;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (super.hurt(source, amount)) {
            LivingEntity attacker = source.getEntity() instanceof LivingEntity ? (LivingEntity) source.getEntity()
                    : null;
            if (attacker != null && System.currentTimeMillis() - lastAlertTime > ALERT_COOLDOWN) {
                this.alertOthers(attacker);
                lastAlertTime = System.currentTimeMillis();
            }
            return true;
        }
        return false;
    }

    private void alertOthers(LivingEntity attacker) {
        double radius = 10.0D;
        List<StormwindGuardEntity> nearbyGuards = this.level.getEntitiesOfClass(StormwindGuardEntity.class,
                this.getBoundingBox().inflate(radius), guard -> guard != this);

        nearbyGuards.stream().limit(5).forEach(guard -> guard.setTarget(attacker));
    }

    static class AlertOthersGoal extends Goal {
        private final StormwindGuardEntity guard;

        public AlertOthersGoal(StormwindGuardEntity guard) {
            this.guard = guard;
            this.setFlags(EnumSet.of(Goal.Flag.TARGET));
        }

        @Override
        public boolean canUse() {
            return this.guard.getTarget() != null && this.guard.getTarget() instanceof Player;
        }

        @Override
        public void start() {
            super.start();
            this.guard.alertOthers(this.guard.getTarget());
        }
    }
}