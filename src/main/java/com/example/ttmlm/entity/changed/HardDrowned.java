package com.example.ttmlm.entity.changed;

import com.example.ttmlm.TTMLM;
import com.example.ttmlm.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class HardDrowned extends DrownedEntity implements IAbstractHardZombie {
    public static final String name = "hard_drowned";

    public HardDrowned(EntityType<? extends DrownedEntity> type, World worldIn) {
        super(ModEntities.HARD_DROWNED, worldIn);
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5.0D);
        this.getAttribute(SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(0.2D);
        this.getAttribute(SWIM_SPEED).setBaseValue(2.0D);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        super.setEquipmentBasedOnDifficulty(worldIn.getDifficultyForLocation(this.getPosition()));
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

}
