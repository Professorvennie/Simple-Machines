package com.professorvennie.simplemachines.machines.solarFurnace;

import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;

/**
 * Created by snows on 11/11/2016.
 */
public class TileEntitySolarFurnace extends TileEntityBasicMachine {

    private int progress, speed = 120;

    public TileEntitySolarFurnace(String name) {
        super(name);
    }

    @Override
    public void update() {
        super.update();

        if (!worldObj.isRemote){
            if (worldObj.canSeeSky(pos) && worldObj.isDaytime() && !worldObj.isRemote && (canSmelt())){
                progress++;
                if (progress == speed){

                }
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return 3;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }
}
