package com.professorvennie.simplemachines.machines.basicGrinder;

import com.professorvennie.simplemachines.blocks.BlockBasicMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by snows on 11/9/2016.
 */
public class BlockBasicGrinder extends BlockBasicMachine {

    public BlockBasicGrinder(String name) {
        super(name);
    }

    @Override
    public int getGuiId() {
        return 2;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityBasicGrinder();
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return new ContainerBasicGrinder(player.inventory, (TileEntityBasicGrinder)world.getTileEntity(new BlockPos(x, y, z)));
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return new GuiBasicGrinder(new ContainerBasicGrinder(player.inventory, (TileEntityBasicGrinder)world.getTileEntity(new BlockPos(x, y, z))), (TileEntityBasicGrinder)world.getTileEntity(new BlockPos(x, y, z)));
    }
}
