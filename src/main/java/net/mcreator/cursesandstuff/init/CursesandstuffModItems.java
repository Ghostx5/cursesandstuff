
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cursesandstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.cursesandstuff.item.CursedGuideItem;
import net.mcreator.cursesandstuff.CursesandstuffMod;

public class CursesandstuffModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CursesandstuffMod.MODID);
	public static final RegistryObject<Item> CURSED_GUIDE = REGISTRY.register("cursed_guide", () -> new CursedGuideItem());
}
