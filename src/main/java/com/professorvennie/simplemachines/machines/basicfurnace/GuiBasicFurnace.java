package com.professorvennie.simplemachines.machines.basicfurnace;

import com.professorvennie.simplemachines.SimpleMachines;
import com.professorvennie.simplemachines.cient.gui.GuiBase;
import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by snows on 11/1/2016.
 */
public class GuiBasicFurnace extends GuiBase {

    public GuiBasicFurnace(Container inventorySlotsIn, TileEntityBasicMachine basicMachine) {
        super(inventorySlotsIn, new ResourceLocation(SimpleMachines.MODID, "textures/gui/basicFurnace.png"), basicMachine);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);

        if (((TileEntityBasicFurnace)basicMachine).isBurning()){
           // System.out.println("WORKING");
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(guiLeft + 56, guiTop + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 14, l + 1, 16);
    }

    private int getBurnLeftScaled(int pixels) {
        int i = basicMachine.getField(0);

        if (i == 0)
            i = 200;

        return basicMachine.getField(0) * pixels / i;
    }

    private int getCookProgressScaled(int pixels) {
        int i = basicMachine.getField(2);
        int j = basicMachine.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
