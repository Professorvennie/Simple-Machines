package com.professorvennie.simplemachines.blocks;

import com.professorvennie.simplemachines.machines.basicGrinder.BlockBasicGrinder;
import com.professorvennie.simplemachines.machines.basicGrinder.TileEntityBasicGrinder;
import com.professorvennie.simplemachines.machines.basicfurnace.BlockBasicFurnace;
import com.professorvennie.simplemachines.machines.basicfurnace.TileEntityBasicFurnace;
import com.professorvennie.simplemachines.machines.miner.BlockBasicMiner;
import com.professorvennie.simplemachines.machines.miner.TileEntityBasicMiner;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by snows on 10/27/2016.
 */
public class ModBlocks {

    public static BlockBasicFurnace blockBasicFurnace;
    public static BlockBasicMiner blockBasicMiner;
    public static BlockBasicGrinder blockBasicGrinder;

    public static void init(){
        blockBasicFurnace = register(new BlockBasicFurnace("basicFurnace"));
        blockBasicMiner = register(new BlockBasicMiner("basicMiner"));
        blockBasicGrinder = register(new BlockBasicGrinder("basicGrinder"));

        GameRegistry.registerTileEntity(TileEntityBasicFurnace.class, "basicFurnace");
        GameRegistry.registerTileEntity(TileEntityBasicMiner.class, "basicMiner");
        GameRegistry.registerTileEntity(TileEntityBasicGrinder.class, "basicGrinder");
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        if (block instanceof BlockBasicMachine) {
            ((BlockBasicMachine)block).registerItemModel(itemBlock);
        }

        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}