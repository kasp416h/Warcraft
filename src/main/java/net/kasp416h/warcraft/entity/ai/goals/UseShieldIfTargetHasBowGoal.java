package net.kasp416h.warcraft.entity.ai.goals;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import com.yourmodid.entity.custom.StormwindGuardEntity;
import java.util.EnumSet;

public class UseShieldIfTargetHasBowGoal extends Goal {
    private final StormwindGuardEntity guard;

    public UseShieldIfTargetHasBowGoal(StormwindGuardEntity guard) {
        this.guard = guard;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        LivingEntity target = guard.getTarget();
        boolean canBlock = target != null && target instanceof Player && target.isHolding(Items.BOW)
                && guard.distanceToSqr(target) < 25;

        guard.setBlocking(canBlock);
        return canBlock;
    }

    @Override
    public void start() {
        guard.startUsingItem(guard.getUsedItemHand());
    }

    @Override
    public boolean canContinueToUse() {
        return canUse();
    }

    @Override
    public void stop() {
        guard.stopUsingItem();
        guard.setBlocking(false);
    }
}
