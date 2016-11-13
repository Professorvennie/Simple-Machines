package com.professorvennie.simplemachines.machines.basicfurnace;


import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Created by snows on 11/1/2016.
 */
public class TileEntityBasicFurnace extends TileEntityBasicMachine {

    private int burnTime, currentBurntime, speed = 90, progress;

    private final int BURN_SLOT = 0,
                      INPUT_SLOT = 1,
                      OUT_1 = 2,
                      OUT_2 = 3;

    public TileEntityBasicFurnace() {
        super("basicFurnace");
    }

    @Override
    public void update() {
        super.update();

        if (burnTime > 0) {
            burnTime--;
            setWorking(true);
            markDirty();
        }else
            setWorking(false);

        if (canWork && !worldObj.isRemote){
            if (isWorking() || inventory[BURN_SLOT] != null && TileEntityFurnace.getItemBurnTime(inventory[BURN_SLOT]) != 0){
                if (!isWorking() && (canSmelt(OUT_1) || canSmelt(OUT_2))){
                    burnTime = currentBurntime = TileEntityFurnace.getItemBurnTime(inventory[BURN_SLOT]);
                    markDirtyClient();
                    //if (isWorking()){
                        if (inventory[BURN_SLOT] != null) {
                            inventory[BURN_SLOT].stackSize--;

                            if (inventory[BURN_SLOT].stackSize == 0) {
                               inventory[BURN_SLOT] = inventory[BURN_SLOT].getItem().getContainerItem(inventory[BURN_SLOT]);
                            }
                        }
                    //}
                }
                if (isWorking() && (canSmelt(OUT_1) || canSmelt(OUT_2))) {
                    progress++;
                    setWorking(true);

                    if (progress == speed) {
                        progress = 0;
                        smeltItem();
                    }
                } else {
                    progress = 0;
                }
            }
        }
    }

    public boolean isBurning() {
        return burnTime > 0;
    }

    @Override
    public int getSizeInventory() {
        return 4;
    }

    @Override
    public int getField(int id) {
        switch (id){
            case 0:
                return burnTime;
            case 1:
                return currentBurntime;
            case 2:
                return progress;
            case 3:
                return speed;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value) {
        switch (id){
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.currentBurntime = value;
                break;
            case 2:
                this.progress = value;
                break;
        }
    }

    @Override
    public int getFieldCount() {
        return 4;
    }

    private boolean canSmelt(int slot) {
        if (slot == OUT_1) {
            if (this.inventory[INPUT_SLOT] == null) {
                return false;
            } else {
                ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventory[INPUT_SLOT]);
                if (itemstack == null) return false;
                if (this.inventory[OUT_1] == null) return true;
                if (!this.inventory[OUT_1].isItemEqual(itemstack)) return false;
                int result = inventory[OUT_1].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.inventory[OUT_1].getMaxStackSize();
            }
        }else if(slot == OUT_2){
            if (this.inventory[INPUT_SLOT] == null) {
                return false;
            }else{
                ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventory[INPUT_SLOT]);
                if (itemstack == null) return false;
                if (this.inventory[OUT_2] == null) return true;
                if (!this.inventory[OUT_2].isItemEqual(itemstack)) return false;
                int result = inventory[OUT_2].stackSize + itemstack.stackSize;
                return result <= getInventoryStackLimit() && result <= this.inventory[OUT_2].getMaxStackSize();
            }
        }
        return false;
    }

    private void smeltItem(){
        if (this.canSmelt(OUT_1)){
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventory[INPUT_SLOT]);

            if (this.inventory[OUT_1] == null){
                this.inventory[OUT_1] = itemstack.copy();
            }
            else if (this.inventory[OUT_1].getItem() == itemstack.getItem()){
                this.inventory[OUT_1].stackSize += itemstack.stackSize;
            }

            this.inventory[INPUT_SLOT].stackSize--;

            if (this.inventory[INPUT_SLOT].stackSize <= 0){
                this.inventory[INPUT_SLOT] = null;
            }
        }else if (this.canSmelt(OUT_2)){
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventory[INPUT_SLOT]);

            if (this.inventory[OUT_2] == null){
                this.inventory[OUT_2] = itemstack.copy();
            }
            else if (this.inventory[OUT_2].getItem() == itemstack.getItem()){
                this.inventory[OUT_2].stackSize += itemstack.stackSize;
            }

            this.inventory[INPUT_SLOT].stackSize--;

            if (this.inventory[INPUT_SLOT].stackSize <= 0){
                this.inventory[INPUT_SLOT] = null;
            }
        }
    }
}
