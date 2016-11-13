package com.professorvennie.simplemachines.machines.solarFurnace;

import com.professorvennie.simplemachines.SimpleMachines;
import com.professorvennie.simplemachines.cient.gui.GuiBase;
import com.professorvennie.simplemachines.tiles.TileEntityBasicMachine;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Created by snows on 11/11/2016.
 */
public class GuiSolarFurnace extends GuiBase {

    public GuiSolarFurnace(Container inventorySlotsIn, TileEntityBasicMachine basicMachine) {
        super(inventorySlotsIn, new ResourceLocation(SimpleMachines.MODID, "textures/gui/solarFurnace.png"), basicMachine);
    }
}
