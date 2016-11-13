package com.professorvennie.simplemachines.machines.miner;

import com.professorvennie.simplemachines.blocks.BlockBasicMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by snows on 11/4/2016.
 */
public class BlockBasicMiner extends BlockBasicMachine {

    public BlockBasicMiner(String name) {
        super(name);
    }

    @Override
    public int getGuiId() {
        return 1;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityBasicMiner();
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}
