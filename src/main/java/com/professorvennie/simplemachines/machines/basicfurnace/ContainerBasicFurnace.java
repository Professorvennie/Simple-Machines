package com.professorvennie.simplemachines.machines.basicfurnace;

import com.professorvennie.simplemachines.common.container.ContainerBase;
import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by snows on 11/1/2016.
 */
public class ContainerBasicFurnace extends ContainerBase {

    private int lastBurnTime, lastCurrentBurnTime, lastProgress;

    public ContainerBasicFurnace(InventoryPlayer inventory, TileEntityBasicMachine basicMachine) {
        super(inventory, basicMachine);
        addSlotToContainer(new Slot(basicMachine, 0, 56, 53));
        addSlotToContainer(new Slot(basicMachine, 1, 56, 17));
        addSlotToContainer(new Slot(basicMachine, 2, 116, 35));
        addSlotToContainer(new Slot(basicMachine, 3, 132, 35));
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < listeners.size(); i++){
            IContainerListener icontainerlistener = this.listeners.get(i);
            if (lastBurnTime != basicMachine.getField(0))
                icontainerlistener.sendProgressBarUpdate(this, 0, basicMachine.getField(0));
            if (lastCurrentBurnTime != basicMachine.getField(1))
                icontainerlistener.sendProgressBarUpdate(this, 1, basicMachine.getField(1));
            if (lastProgress != basicMachine.getField(2))
                icontainerlistener.sendProgressBarUpdate(this, 2, basicMachine.getField(2));
        }
        lastBurnTime = basicMachine.getField(0);
        lastCurrentBurnTime = basicMachine.getField(1);
        lastProgress = basicMachine.getField(2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        basicMachine.setField(id, data);
    }
}
