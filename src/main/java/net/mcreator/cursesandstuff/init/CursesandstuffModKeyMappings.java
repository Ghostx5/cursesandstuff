
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cursesandstuff.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.cursesandstuff.network.ResetDataMessage;
import net.mcreator.cursesandstuff.CursesandstuffMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CursesandstuffModKeyMappings {
	public static final KeyMapping RESET_DATA = new KeyMapping("key.cursesandstuff.reset_data", GLFW.GLFW_KEY_BACKSLASH, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				CursesandstuffMod.PACKET_HANDLER.sendToServer(new ResetDataMessage(0, 0));
				ResetDataMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CAST_VEIL = new KeyMapping("key.cursesandstuff.cast_veil", GLFW.GLFW_KEY_V, "key.categories.misc");

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(RESET_DATA);
		event.register(CAST_VEIL);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				RESET_DATA.consumeClick();
			}
		}
	}
}
