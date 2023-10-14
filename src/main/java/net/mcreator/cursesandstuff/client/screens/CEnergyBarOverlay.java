
package net.mcreator.cursesandstuff.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.cursesandstuff.procedures.ThirBarTrigProcedure;
import net.mcreator.cursesandstuff.procedures.TenBarTrigProcedure;
import net.mcreator.cursesandstuff.procedures.SixBarTrigProcedure;
import net.mcreator.cursesandstuff.procedures.SevBarTrigProcedure;
import net.mcreator.cursesandstuff.procedures.SeconBarTrigProcedure;
import net.mcreator.cursesandstuff.procedures.ReturnNumberProcedure;
import net.mcreator.cursesandstuff.procedures.NinBarTrigProcedure;
import net.mcreator.cursesandstuff.procedures.FourBarTrigProcedure;
import net.mcreator.cursesandstuff.procedures.FiveBarTrigProcedure;
import net.mcreator.cursesandstuff.procedures.FirstBarTrigProcedure;
import net.mcreator.cursesandstuff.procedures.EigBarTrigProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class CEnergyBarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/blankexp.png"), posX + -90, posY + 68, 0, 0, 102, 7, 102, 7);

			if (FirstBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + -90, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			if (SeconBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + -80, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			if (ThirBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + -70, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			if (FourBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + -60, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			if (FiveBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + -50, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			if (SixBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + -40, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			if (SevBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + -30, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			if (EigBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + -20, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			if (NinBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + -10, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			if (TenBarTrigProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("cursesandstuff:textures/screens/fullexp.png"), posX + 0, posY + 68, 0, 0, 102, 7, 102, 7);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnNumberProcedure.execute(entity), posX + -194, posY + 95, -16737895, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
