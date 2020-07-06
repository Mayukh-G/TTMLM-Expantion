package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class ModBlocks {
    public static Block bigSlip;

    public static void  registerAll(RegistryEvent.Register<Block> event) {
        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) return;

        bigSlip = register("big_slip", new Block(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(1.5f,6f)
                .sound(SoundType.STONE)
        ));

        for(CoalVariants coalVariants : CoalVariants.values()){
            //BlockItem needs to be added, with overridden class
            register(coalVariants.getName() + "_block", coalVariants.getCoalVariantBlock());
        }

        for (CoalVariants coalVariants : CoalVariants.values()){
            //GENERATE THESE IN CORRECT BIOMES
            register(coalVariants.getName() + "_ore", coalVariants.getOreBlocks());
        }


    }

    private static <T extends Block> T register(String name,T block ) {
        BlockItem item = new BlockItem(block, new Item.Properties().group(ExampleMod.ITEM_GROUP));
        return register(name, block, item);
    }

    private static <T extends Block> T register(String name, T block, @Nullable BlockItem item) {
        ResourceLocation id = ExampleMod.getID(name);
        block.setRegistryName(id);
        ForgeRegistries.BLOCKS.register(block);
        if (item != null){
            ModItems.BLOCKS_TO_REGISTER.put(name, item);
        }
        return block;
    }

}
