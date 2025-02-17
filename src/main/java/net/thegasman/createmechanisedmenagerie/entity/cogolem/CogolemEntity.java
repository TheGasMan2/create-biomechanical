package net.thegasman.createmechanisedmenagerie.entity.cogolem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

import javax.annotation.Nullable;

public class CogolemEntity extends PathfinderMob implements GeoEntity {
    private boolean justSpawned = true;
    private boolean spawnAnimationComplete = false;
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public CogolemEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        // Only allow attacking after the spawn animation completes.
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.5D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        // Exclude this entity type from being targeted by other CogolemEntities
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, true) {
            @Override
            public boolean canUse() {
                // Exclude CogolemEntities from targeting other CogolemEntities
                if (super.canUse()) {
                    return !(target instanceof CogolemEntity);
                }
                return false;
            }
        });
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 50.0D)
                .add(Attributes.ARMOR, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        AnimationController<CogolemEntity> controller = new AnimationController<>(this, "controller", 0, this::predicate);
        controllerRegistrar.add(controller);
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        AnimationController<CogolemEntity> controller = (AnimationController<CogolemEntity>) tAnimationState.getController();

        // Handle spawn animation
        if (this.justSpawned) {
            controller.setAnimation(RawAnimation.begin().then("wakeup", Animation.LoopType.PLAY_ONCE));
            if (controller.getAnimationState() == AnimationController.State.STOPPED) {
                this.justSpawned = false;
                this.spawnAnimationComplete = true;
            }
            return PlayState.CONTINUE;
        }

        // Handle attack animation
        if (this.isAttacking()) {
            controller.setAnimation(RawAnimation.begin().then("attack", Animation.LoopType.PLAY_ONCE));
            if (controller.getAnimationState() == AnimationController.State.STOPPED) {
                this.setAttack(false); // Reset attack state after animation completes
            }
            return PlayState.CONTINUE;
        }

        // Handle chasing animation
        if (this.isChasing()) {
            controller.setAnimation(RawAnimation.begin().then("oldidle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        // Handle walking animation
        if (this.getDeltaMovement().horizontalDistanceSqr() > 0.0001) {
            controller.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
        } else {
            controller.setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        }

        return PlayState.CONTINUE;
    }

    /**
     * Determines if the entity is currently chasing a target.
     * @return true if chasing, false otherwise.
     */
    public boolean isChasing() {
        return this.getTarget() != null && this.getNavigation().isInProgress();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean flag = super.doHurtTarget(target);
        if (flag) {
            this.setAttack(true); // Trigger attack animation
        }
        return flag;
    }

    private boolean isAttacking = false;

    public void setAttack(boolean attacking) {
        this.isAttacking = attacking;
    }

    public boolean isAttacking() {
        return this.isAttacking;
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        // Set the hitbox size: 2.5 blocks tall and 1.5 blocks wide
        return EntityDimensions.scalable(1.5F, 2.5F);  // width, height
    }

    @Override
    public void setCustomName(@Nullable Component pName) {
        super.setCustomName(pName);
        // Optional: Apply specific adjustments when the entity name is set
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (this.isAttacking() && this.tickCount % 20 == 0) { // Adjust timing as needed
            this.setAttack(false);
        }
    }

}
