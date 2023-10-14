package net.mcreator.cursesandstuff.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.cursesandstuff.network.CursesandstuffModVariables;

public class ResetEnergyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(CursesandstuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.cursedEnergy = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
