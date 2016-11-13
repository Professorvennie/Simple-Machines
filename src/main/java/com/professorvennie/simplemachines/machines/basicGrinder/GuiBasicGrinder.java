package com.professorvennie.simplemachines.machines.basicGrinder;

import com.professorvennie.simplemachines.SimpleMachines;
import com.professorvennie.simplemachines.cient.gui.GuiBase;
import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by snows on 11/9/2016.
 */
public class GuiBasicGrinder extends GuiBase {

    public GuiBasicGrinder(Container inventorySlotsIn, TileEntityBasicMachine basicMachine) {
        super(inventorySlotsIn, new ResourceLocation(SimpleMachines.MODID, "textures/gui/basicGrinder.png"), basicMachine);
    }
}
