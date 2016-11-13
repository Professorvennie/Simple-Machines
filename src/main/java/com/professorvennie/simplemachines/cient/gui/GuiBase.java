package com.professorvennie.simplemachines.cient.gui;

import com.professorvennie.simplemachines.SimpleMachines;
import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by snows on 11/1/2016.
 */
public class GuiBase extends GuiContainer {

    private ResourceLocation backGround;
    public TileEntityBasicMachine basicMachine;

    public GuiBase(Container inventorySlotsIn, ResourceLocation backGround, TileEntityBasicMachine basicMachine) {
        super(inventorySlotsIn);
        this.backGround = backGround;
        this.basicMachine = basicMachine;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRendererObj.drawString(I18n.format("container.inventory", SimpleMachines.INSTANSE), 8, this.ySize - 96 + 2, 4210752);
        String name = "";
        if (basicMachine != null)
            name = net.minecraft.util.text.translation.I18n.translateToLocal("container." + basicMachine.getCustomName());
        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        if (backGround != null){
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            mc.getTextureManager().bindTexture(backGround);
            drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        }
    }
}
