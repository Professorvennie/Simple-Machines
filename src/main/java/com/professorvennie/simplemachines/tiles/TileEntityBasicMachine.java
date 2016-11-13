package com.professorvennie.simplemachines.tiles;

import com.professorvennie.simplemachines.tiles.interfaces.IButtonHandler;
import com.professorvennie.simplemachines.tiles.interfaces.IRedstoneControllable;
import com.professorvennie.simplemachines.tiles.interfaces.RedstoneMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snows on 10/30/2016.
 */
public abstract class TileEntityBasicMachine extends TileEntityBasicSidedInventory implements IButtonHandler, IRedstoneControllable {

    public boolean canWork;
    private RedstoneMode redStoneMode;
    public boolean isActive;
    private boolean isWorking;

    public TileEntityBasicMachine(String name) {
        super(name);
        redStoneMode = RedstoneMode.low;
    }

    @Override
    public void update() {
        updateRedStone();
    }

    public void updateRedStone(){
        switch (redStoneMode) {
            case low:
                if (worldObj.isBlockIndirectlyGettingPowered(pos) <= 0)
                    canWork = true;
                else
                    canWork = false;
                break;
            case high:
                if (worldObj.isBlockIndirectlyGettingPowered(pos) > 0)
                    canWork = true;
                else
                    canWork = false;
                break;
            case disabled:
                canWork = true;
                break;
            default:
                canWork = false;
                break;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        redStoneMode = RedstoneMode.values()[nbtTagCompound.getInteger("Mode")];
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setInteger("Mode", redStoneMode.ordinal());
        return nbtTagCompound;
    }

    @Override
    public void handleClick(int id) {
        switch (id) {
            case 0:
                setRedstoneMode(RedstoneMode.high);
                break;
            case 1:
                setRedstoneMode(RedstoneMode.disabled);
                break;
            case 2:
                setRedstoneMode(RedstoneMode.low);
                break;
        }
    }

    public void markDirtyClient() {
        markDirty();
        if (worldObj != null) {
            IBlockState state = worldObj.getBlockState(getPos());
            worldObj.notifyBlockUpdate(getPos(), state, state, 3);
        }
    }


    @Override
    public RedstoneMode getRedStoneMode() {
        return redStoneMode;
    }

    @Override
    public void setRedstoneMode(RedstoneMode mode) {
        this.redStoneMode = mode;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    @SuppressWarnings("unchekced")
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            switch (facing){
                case DOWN:
                    return (T) new SidedInvWrapper(this, EnumFacing.DOWN);
                case UP:
                    return (T) new SidedInvWrapper(this, EnumFacing.UP);
                default:
                    return (T) new SidedInvWrapper(this, EnumFacing.WEST);
            }
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }
}
