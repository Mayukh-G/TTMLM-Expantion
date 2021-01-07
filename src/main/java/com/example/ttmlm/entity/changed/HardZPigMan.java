package com.example.ttmlm.entity.changed;

import com.example.ttmlm.TTMLM;
import com.example.ttmlm.entity.original.NetherBoss;
import com.example.ttmlm.init.IngotVariants;
import com.example.ttmlm.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class HardZPigMan extends ZombiePigmanEntity implements IAbstractHardZombie {
    public static final String name = "hard_zombie_pigman";

    public HardZPigMan(EntityType<?> type, World world) {
        super(ModEntities.HARD_Z_PIGMAN, world);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(IngotVariants.WEAK_BLAZING_AllOY.getSwordItem()));
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(IngotVariants.BLAZING_ALLOY.getHelmetItem()));
        this.inventoryHandsDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 0F;
        this.inventoryArmorDropChances[EquipmentSlotType.HEAD.getIndex()] = 0;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.40D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5.0D);
    }

    //make sure we dont retaliate against the boss
    @Override
    public void setRevengeTarget(@Nullable LivingEntity livingBase) {
        if (livingBase instanceof NetherBoss){
            super.setRevengeTarget(null);
        }else {
            super.setRevengeTarget(livingBase);
        }
    }
}
