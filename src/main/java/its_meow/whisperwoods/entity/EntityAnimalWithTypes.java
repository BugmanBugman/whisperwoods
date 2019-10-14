package its_meow.whisperwoods.entity;

import java.util.Random;

import javax.annotation.Nullable;

import its_meow.whisperwoods.init.ModEntities;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class EntityAnimalWithTypes extends AnimalEntity implements IVariantTypes {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityAnimalWithTypes.class, DataSerializers.VARINT);
    
    public EntityAnimalWithTypes(EntityType<? extends AnimalEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }
    
    @Override
    protected void registerData() {
        super.registerData();
        this.registerTypeKey();
    }
    
    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.writeType(compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readType(compound);
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        return this.initData(super.onInitialSpawn(world, difficulty, reason, livingdata, compound));
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        if(!(ageable instanceof IVariantTypes)) return null;
        IVariantTypes child = getBaseChild();
        if(child == null) return null;
        return (AgeableEntity) child.setType(this.getOffspringType(this, (IVariantTypes) ageable));
    }
    
    protected abstract IVariantTypes getBaseChild();
    
    @Override
    public boolean isChildI() {
        return this.isChild();
    }

    @Override
    public Random getRNGI() {
        return this.getRNG();
    }

    @Override
    public EntityDataManager getDataManagerI() {
        return this.getDataManager();
    }

    @Override
    public DataParameter<Integer> getDataKey() {
        return TYPE_NUMBER;
    }
    
    protected abstract String getContainerName();

    @Override
    public boolean canDespawn(double range) {
        return ModEntities.ENTITIES.containsKey(this.getContainerName()) ? ModEntities.ENTITIES.get(this.getContainerName()).despawn : false;
    }
    
}