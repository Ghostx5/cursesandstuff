package net.mcreator.cursesandstuff.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.cursesandstuff.network.CursesandstuffModVariables;

public class EigBarTrigProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(CursesandstuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CursesandstuffModVariables.PlayerVariables())).cursedEnergy >= 80) {
			return true;
		}
		return false;
	}
}
