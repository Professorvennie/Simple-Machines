package com.professorvennie.simplemachines.common.container;

import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;

/**
 * Created by snows on 11/1/2016.
 */
public class ContainerBase extends Container {

    public TileEntityBasicMachine basicMachine;

    public ContainerBase(InventoryPlayer inventory, TileEntityBasicMachine basicMachine){
        this.basicMachine = basicMachine;
        addPlayersInv(inventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return basicMachine.isUseableByPlayer(playerIn);
    }

    private void addPlayersInv(InventoryPlayer inventory){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, basicMachine);
    }
}
