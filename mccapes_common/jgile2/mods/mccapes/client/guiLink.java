package jgile2.mods.mccapes.client;

import jgile2.mods.mccapes.linkAccount;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.network.NetServerHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;

public class guiLink extends GuiScreen {
	public EntityPlayer entity;
	private GuiTextField pass;
	private GuiTextField user;
	boolean con = false;
	private static final ResourceLocation guiLink = new ResourceLocation("mccapes:textures/gui/Link.png");
	

	public guiLink(EntityPlayer player) {
		con = false;
		//xSize = 175;
		//ySize = 222;
		//entity = player;
		entity = player;
		System.out.println(entity.username);
	}
	@Override
	public void initGui(){
		int xStart = this.width - 176 >> 1;
		int yStart = this.height - 214 >> 1;
		this.user = new GuiTextField(this.fontRenderer, xStart+10,yStart+40, 150, 20);	
		this.pass = new GuiTextField(this.fontRenderer, xStart+10,yStart+100, 150, 20);	
		this.user.setFocused(false);
		this.user.setMaxStringLength(16);
	}
	


	@Override
	public void drawScreen(int x, int y,float f) {
		//super.drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(guiLink);
		int xStart = this.width - 176 >> 1;
		int yStart = this.height - 214 >> 1;
		drawTexturedModalRect(xStart, yStart, 0, 0, 176, 214);
		//this.user = new GuiTextField(this.fontRenderer, +13,40, 150, 20);	
		//this.pass = new GuiTextField(this.fontRenderer, +13,100, 150, 20);	
		//this.user.setText("UserName");
		this.user.drawTextBox();
		this.pass.drawTextBox();
		

		this.fontRenderer.drawString("Link", xStart+10, yStart+5, 4210752);
		this.fontRenderer.drawString("Username", xStart+110, yStart+30, 4210752);
		this.fontRenderer.drawString("Password", xStart+110,yStart+90, 4210752);
		buttonList.add(new GuiButton(1, xStart+40,yStart+140, +100, 20, "Link"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		
	//	this.drawTexturedModalRect(125, 20, 0, 0, this.height, this.width);
		super.drawScreen(x, y, f);
	}

	
	
	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		super.mouseClicked(par1, par2, par3);
		this.user.mouseClicked(par1, par2, par3);
		this.pass.mouseClicked(par1, par2, par3);
		
	}
	@Override
	public void keyTyped(char par1, int par2) {
		if (this.user.isFocused()) {
			this.user.textboxKeyTyped(par1, par2);
		} else if (this.pass.isFocused()) {
			this.pass.textboxKeyTyped(par1, par2);
		}
		super.keyTyped(par1, par2);
		
	}
	
	@Override
	protected void actionPerformed(GuiButton gb) {
		switch(gb.id){
		case 1:
			if(!con){
				
				String user = this.user.getText();
				String pass = this.pass.getText();
				entity.addChatMessage("Linking Username: "+user+" with password: "+pass);
				
				linkAccount la = new linkAccount(user,pass);
				con = true;
				
			}
			break;
			
		}
	}
}
