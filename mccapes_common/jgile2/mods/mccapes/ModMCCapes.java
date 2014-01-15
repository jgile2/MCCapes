package jgile2.mods.mccapes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.IChatListener;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
@Mod(modid = "mod_MCCapes", name = "MC Capes by jgile2", version = "0.0.0.1", useMetadata = true)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"mod_MCCapes"}, packetHandler = PacketHandler.class)

public class ModMCCapes
{

  
    @PreInit
    public void init(FMLPreInitializationEvent event)
    {

    }
    @Instance("mod_MCCapes")
    public static ModMCCapes instance = new ModMCCapes();
    public GuiHandler guihandler = new GuiHandler();

    @Init
    public void load(FMLInitializationEvent event) throws IOException
    {
        
        NetworkRegistry.instance().registerGuiHandler(instance, guihandler);
       }

    
    @PostInit
    public void postInit(FMLPostInitializationEvent event){

    }
   

    @ServerStarting
    public void serverLoad(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new cmdLink());
       
    }
}
