package com.professorvennie.simplemachines.core.proxeys;

import com.professorvennie.simplemachines.SimpleMachines;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by snows on 10/27/2016.
 */
public class ClientProxey extends CommonProxey {

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(SimpleMachines.MODID + ":" + id, "inventory"));
    }
}
