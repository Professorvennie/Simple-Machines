package com.professorvennie.simplemachines.core.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by snows on 10/27/2016.
 */
public class GuiHandler implements IGuiHandler {

    private Map<Integer, IGuiHandler> guiHandlers = new HashMap<>();

    public void registerHandler(int id, IGuiHandler handler) {
        guiHandlers.putIfAbsent(id, handler);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (guiHandlers.get(ID) != null)
            return guiHandlers.get(ID).getServerGuiElement(ID, player, world, x, y, z);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (guiHandlers.get(ID) != null)
            return guiHandlers.get(ID).getClientGuiElement(ID, player, world, x, y, z);
        return null;
    }
}
