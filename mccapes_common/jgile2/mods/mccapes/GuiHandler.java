package jgile2.mods.mccapes;

import jgile2.mods.mccapes.client.fakeContainer;
import jgile2.mods.mccapes.client.guiLink;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	public GuiHandler() {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		if (ID == 1) {
			return new fakeContainer();
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		if (ID == 1) {
			return new guiLink(player);
		}

		return null;
	}

}
