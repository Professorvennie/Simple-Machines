package com.professorvennie.simplemachines.machines.basicfurnace;

import com.professorvennie.simplemachines.blocks.BlockBasicMachine;
import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by snows on 10/30/2016.
 */
public class BlockBasicFurnace extends BlockBasicMachine {

    public BlockBasicFurnace(String name) {
        super(name);
    }

    @Override
    public int getGuiId() {
        return 0;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityBasicFurnace();
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return new ContainerBasicFurnace(player.inventory, (TileEntityBasicFurnace)world.getTileEntity(new BlockPos(x, y, z)));
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return new GuiBasicFurnace(new ContainerBasicFurnace(player.inventory, (TileEntityBasicFurnace)world.getTileEntity(new BlockPos(x, y, z))), (TileEntityBasicFurnace)world.getTileEntity(new BlockPos(x, y, z)));
    }
}
