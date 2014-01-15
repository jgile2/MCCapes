package jgile2.mods.mccapes;

import java.util.ArrayList;
import java.util.List;

import jgile2.mods.mccapes.client.guiLink;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLDummyContainer;
import cpw.mods.fml.common.network.FMLNetworkHandler;

public class cmdLink extends CommandBase{
	private EntityPlayer player;


	private List aliases;
	  public cmdLink()
	    {
	        this.aliases = new ArrayList();
	        this.aliases.add("capeLink");
	    }
	@Override
	public String getCommandName() {
		return "capeLink";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "capeLink";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		player = (EntityPlayer)icommandsender;
		guiLink gui = new guiLink(player);
	
		//player.openGui(ModMCCapes.instance, 1, player.worldObj,(int) player.posX,(int) player.posY,(int) player.posZ);
		//FMLNetworkHandler.openGui(player,ModMCCapes.instance, 1, player.worldObj,(int) player.posX,(int) player.posY,(int) player.posZ);
		
		//FMLClientHandler.instance().displayGuiScreen(player, gui);
		Minecraft mc = Minecraft.getMinecraft();
		mc.displayGuiScreen(gui);

}

}
