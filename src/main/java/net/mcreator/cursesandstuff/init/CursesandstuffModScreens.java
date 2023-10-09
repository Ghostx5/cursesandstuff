
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cursesandstuff.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.cursesandstuff.client.gui.CursePage2Screen;
import net.mcreator.cursesandstuff.client.gui.CursePage1Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CursesandstuffModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(CursesandstuffModMenus.CURSE_PAGE_2.get(), CursePage2Screen::new);
			MenuScreens.register(CursesandstuffModMenus.CURSE_PAGE_1.get(), CursePage1Screen::new);
		});
	}
}
