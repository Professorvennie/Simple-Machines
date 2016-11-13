package com.professorvennie.simplemachines.machines.solarFurnace;

import com.professorvennie.simplemachines.blocks.BlockBasicMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by snows on 11/11/2016.
 */
public class BlockSolarFurnace extends BlockBasicMachine {

    public BlockSolarFurnace(String name) {
        super(name);
    }

    @Override
    public int getGuiId() {
        return 3;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntitySolarFurnace("solarFurnace");
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntitySolarFurnace tile = (TileEntitySolarFurnace)world.getTileEntity(new BlockPos(x, y, z));
        return new ContainerSolarFruance(player.inventory, tile);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntitySolarFurnace tile = (TileEntitySolarFurnace)world.getTileEntity(new BlockPos(x, y, z));
        return new GuiSolarFurnace(new ContainerSolarFruance(player.inventory, tile), tile);
    }
}
