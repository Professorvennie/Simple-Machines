package com.professorvennie.simplemachines;

import com.professorvennie.simplemachines.blocks.ModBlocks;
import com.professorvennie.simplemachines.core.handlers.GuiHandler;
import com.professorvennie.simplemachines.core.proxeys.CommonProxey;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = SimpleMachines.MODID, version = SimpleMachines.VERSION, name = SimpleMachines.NAME)
public class SimpleMachines {

    public static final String MODID = "simplemachines";
    public static final String NAME = "Simple Machines";
    public static final String VERSION = "0.1.0";
    public static final String COMMONPROXEY = "com.professorvennie.simplemachines.core.proxeys.CommonProxey";
    public static final String CLIENTPROXEY = "com.professorvennie.simplemachines.core.proxeys.ClientProxey";

    @Mod.Instance
    public static SimpleMachines INSTANSE;

    @SidedProxy(clientSide = SimpleMachines.CLIENTPROXEY, serverSide = SimpleMachines.COMMONPROXEY)
    public static CommonProxey proxey;

    public static GuiHandler guiHandler = new GuiHandler();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ModBlocks.init();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(SimpleMachines.MODID, guiHandler);
    }

    public static CreativeTabs tabMain = new CreativeTabs("tabMain") {
        @Override
        public Item getTabIconItem() {
            return Items.DIAMOND;
        }
    };
}
