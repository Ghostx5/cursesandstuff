
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cursesandstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.cursesandstuff.world.inventory.CursePage2Menu;
import net.mcreator.cursesandstuff.world.inventory.CursePage1Menu;
import net.mcreator.cursesandstuff.CursesandstuffMod;

public class CursesandstuffModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, CursesandstuffMod.MODID);
	public static final RegistryObject<MenuType<CursePage2Menu>> CURSE_PAGE_2 = REGISTRY.register("curse_page_2", () -> IForgeMenuType.create(CursePage2Menu::new));
	public static final RegistryObject<MenuType<CursePage1Menu>> CURSE_PAGE_1 = REGISTRY.register("curse_page_1", () -> IForgeMenuType.create(CursePage1Menu::new));
}
