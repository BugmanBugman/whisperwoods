package dev.itsmeow.whisperwoods.entity;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.whisperwoods.init.ModEntities;
import dev.itsmeow.whisperwoods.util.StopSpinningClimberPathNavigator;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSetPassengersPacket;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.WalkAndSwimNodeProcessor;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeMod;

import java.util.Random;

public class EntityZotzpyre extends EntityMonsterWithTypes {

    private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(EntityZotzpyre.class, DataSerializers.BYTE);
    protected int lastAttack = 0;
    private boolean isFromZotz = false;

    public EntityZotzpyre(World world) {
        super(ModEntities.ZOTZPYRE.entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new LeapAtTargetGoal(this, 0.5F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MobEntity.class, 0, true, true, entity -> !(entity instanceof EntityZotzpyre) && !(entity instanceof AbstractHorseEntity) && !(entity instanceof AmbientEntity) && !(entity instanceof IMob) && entity.getCreatureAttribute() != CreatureAttribute.UNDEAD));
    }

    protected PathNavigator createNavigator(World worldIn) {
        return new StopSpinningClimberPathNavigator(this, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(CLIMBING, (byte) 0);
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void collideWithEntity(Entity entityIn) {
    }

    @Override
    protected void collideWithNearbyEntities() {
    }

    @Override
    public void tick() {
        if (this.isPassenger()) {
            this.setNoAI(true);
            // you'd think it wouldn't be null. except it is. on turtles in water?
            // explain MINECRAFT. EXPLAIN.
            if (this.getNavigator().getNodeProcessor() == null) {
                this.getNavigator().nodeProcessor = new WalkAndSwimNodeProcessor();
            }
        } else if (this.isAIDisabled()) {
            this.setNoAI(false);
        }
        super.tick();
        if (!this.world.isRemote && !this.isAlive() && this.getRidingEntity() != null || (!this.world.isRemote && this.getRidingEntity() != null && !this.getRidingEntity().isAlive())) {
            this.dismountZotz();
        }
        if (!this.world.isRemote) {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }
    }

    /* prevent slowdown in air */
    @Override
    public void travel(Vector3d vec) {
        ModifiableAttributeInstance gravity = this.getAttribute(ForgeMod.ENTITY_GRAVITY.get());
        boolean flag = this.getMotion().y <= 0.0D;
        double d0 = gravity != null ? gravity.getValue() : 0.08D;
        double d1 = this.getPosY();
        float f = this.isSprinting() ? 0.9F : this.getWaterSlowDown();
        float f1 = 0.02F;
        float f2 = (float) EnchantmentHelper.getDepthStriderModifier(this);
        if (f2 > 3.0F) {
            f2 = 3.0F;
        }

        if (f2 > 0.0F) {
            f += (0.54600006F - f) * f2 / 3.0F;
            f1 += (this.getAIMoveSpeed() - f1) * f2 / 3.0F;
        }

        if (this.isPotionActive(Effects.DOLPHINS_GRACE)) {
            f = 0.96F;
        }

        f1 *= this.getAttribute(ForgeMod.SWIM_SPEED.get()).getValue();
        this.moveRelative(f1, vec);
        this.move(MoverType.SELF, this.getMotion());
        Vector3d vec3d1 = this.getMotion();
        if (this.collidedHorizontally && this.isOnLadder()) {
            vec3d1 = new Vector3d(vec3d1.x, 0.2D, vec3d1.z);
        }

        this.setMotion(vec3d1.mul(f, 0.8F, f));
        if (!this.hasNoGravity() && !this.isSprinting()) {
            Vector3d vec3d2 = this.getMotion();
            double d2;
            if (flag && Math.abs(vec3d2.y - 0.005D) >= 0.003D && Math.abs(vec3d2.y - d0 / 16.0D) < 0.003D) {
                d2 = -0.003D;
            } else {
                d2 = vec3d2.y - d0 / 16.0D;
            }

            this.setMotion(vec3d2.x, d2, vec3d2.z);
        }

        Vector3d vec3d6 = this.getMotion();
        if (this.collidedHorizontally && this.isOffsetPositionInLiquid(vec3d6.x, vec3d6.y + (double) 0.6F - this.getPosY() + d1, vec3d6.z)) {
            this.setMotion(vec3d6.x, 0.3F, vec3d6.z);
        }


        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d5 = this.getPosX() - this.prevPosX;
        double d6 = this.getPosZ() - this.prevPosZ;
        double d8 = this instanceof IFlyingAnimal ? this.getPosY() - this.prevPosY : 0.0D;
        float f8 = MathHelper.sqrt(d5 * d5 + d8 * d8 + d6 * d6) * 4.0F;
        if (f8 > 1.0F) {
            f8 = 1.0F;
        }

        this.limbSwingAmount += (f8 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

    @Override
    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }

    public boolean isBesideClimbableBlock() {
        return (this.dataManager.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = this.dataManager.get(CLIMBING);
        this.dataManager.set(CLIMBING, climbing ? (byte) (b0 | 1) : (byte) (b0 & -2));
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.05F;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BAT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_BAT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote && this.getAttackTarget() != null && this.getAttackTarget().isAlive()) {
            if (this.getRidingEntity() != null && this.getRidingEntity() == this.getAttackTarget()) {
                float time = 20F;
                if (!this.inWater) {
                    time *= 2F * (Math.random() + 1F);
                } else {
                    time += Math.random() * Math.random() * 2 * ((Math.random() < 0.5) ? -1 : 1);
                }
                if (this.lastAttack + time < this.ticksExisted) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
            } else if (this.getDistanceSq(this.getAttackTarget()) < 3) {
                this.grabTarget(this.getAttackTarget());
            }
        }
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return true;
    }

    public void grabTarget(Entity entity) {
        if (!world.isRemote) {
            if (this.getRidingEntity() == null) {
                this.startRiding(entity, true);
                for (ServerPlayerEntity player : this.world.getServer().getPlayerList().getPlayers()) {
                    if (player.world == this.world && player.getDistance(this) <= 128) {
                        player.connection.sendPacket(new SSetPassengersPacket(entity));
                    }
                }
            }
        }
    }

    public void dismountZotz() {
        Entity mount = this.getRidingEntity();
        this.isFromZotz = true;
        this.stopRiding();
        this.isFromZotz = false;
        if (!world.isRemote && this.world.getServer() != null) {
            for (ServerPlayerEntity player : this.world.getServer().getPlayerList().getPlayers()) {
                if (player.world == this.world && player.getDistance(this) <= 128) {
                    player.connection.sendPacket(new SSetPassengersPacket(mount));
                }
            }
        }
    }

    @Override
    public void stopRiding() {
        if (this.getRidingEntity() != null && !this.getRidingEntity().canBeRiddenInWater(this)) {
            super.stopRiding();
        } else if (this.getAttackTarget() == null || isFromZotz) {
            super.stopRiding();
        }
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public double getYOffset() {
        if (getRidingEntity() != null && getRidingEntity() instanceof PlayerEntity) {
            return getRidingEntity().getHeight() - 2.25F;
        } else if (getRidingEntity() != null) {
            return (getRidingEntity().getEyeHeight() / 2) - this.getHeight();
        } else {
            return super.getYOffset();
        }
    }

    @SuppressWarnings("deprecation")
    public static boolean canSpawn(EntityType<EntityZotzpyre> type, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
        if (pos.getY() >= world.getSeaLevel() && !BiomeDictionary.getTypes(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, world.getBiome(pos).getRegistryName())).contains(BiomeDictionary.Type.JUNGLE)) {
            return false;
        } else {
            return canMonsterSpawn(type, world, reason, pos, rand);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            if (amount > 3 && this.getRidingEntity() != null && !this.world.isRemote) {
                this.dismountZotz();
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if (flag) {
            this.lastAttack = this.ticksExisted;
            if (entityIn instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entityIn;
                int slowTicks = 0;
                if (this.world.getDifficulty() == Difficulty.EASY) {
                    slowTicks = 200; // 10s
                } else if (this.world.getDifficulty() == Difficulty.NORMAL) {
                    slowTicks = 300; // 15s
                } else if (this.world.getDifficulty() == Difficulty.HARD) {
                    slowTicks = 600; // 30s
                }
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, slowTicks, 1, false, false));
            }
        }
        if (!this.world.isRemote && !entityIn.isAlive() && entityIn == this.getRidingEntity()) {
            this.dismountZotz();
        }
        return flag;
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    @Override
    public EntityTypeContainer<EntityZotzpyre> getContainer() {
        return ModEntities.ZOTZPYRE;
    }

}
