package net.mcreator.cursesandstuff.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.cursesandstuff.world.inventory.CursePage2Menu;
import net.mcreator.cursesandstuff.network.CursePage2ButtonMessage;
import net.mcreator.cursesandstuff.CursesandstuffMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CursePage2Screen extends AbstractContainerScreen<CursePage2Menu> {
	private final static HashMap<String, Object> guistate = CursePage2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_previous;

	public CursePage2Screen(CursePage2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 317;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("cursesandstuff:textures/screens/curse_page_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.cursesandstuff.curse_page_2.label_the_limitless_technique"), 94, 13, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.cursesandstuff.curse_page_2.label_this_is_a_placeholder_for_the_te"), 46, 54, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_previous = Button.builder(Component.translatable("gui.cursesandstuff.curse_page_2.button_previous"), e -> {
			if (true) {
				CursesandstuffMod.PACKET_HANDLER.sendToServer(new CursePage2ButtonMessage(0, x, y, z));
				CursePage2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 14, this.topPos + 140, 82, 20).build();
		guistate.put("button:button_previous", button_previous);
		this.addRenderableWidget(button_previous);
	}
}
