package com.professorvennie.simplemachines.machines.basicGrinder;

import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
/**
 * Created by snows on 11/9/2016.
 */
public class TileEntityBasicGrinder extends TileEntityBasicMachine {

    public TileEntityBasicGrinder() {
        super("basicGrinder");
    }

    @Override
    public void update() {
        super.update();
        
    }

    @Override
    public int getSizeInventory() {
        return 0;
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
