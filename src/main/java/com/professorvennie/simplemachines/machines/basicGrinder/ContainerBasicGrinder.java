package com.professorvennie.simplemachines.machines.basicGrinder;

import com.professorvennie.simplemachines.common.container.ContainerBase;
import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.entity.player.InventoryPlayer;

/**
 * Created by snows on 11/9/2016.
 */
public class ContainerBasicGrinder extends ContainerBase {

    public ContainerBasicGrinder(InventoryPlayer inventory, TileEntityBasicMachine basicMachine) {
        super(inventory, basicMachine);
    }
}
