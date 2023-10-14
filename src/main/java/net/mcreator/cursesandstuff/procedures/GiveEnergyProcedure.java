package net.mcreator.cursesandstuff.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.cursesandstuff.network.CursesandstuffModVariables;
import net.mcreator.cursesandstuff.CursesandstuffMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GiveEnergyProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CursesandstuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CursesandstuffModVariables.PlayerVariables())).cursedEnergy < (entity
				.getCapability(CursesandstuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CursesandstuffModVariables.PlayerVariables())).MaxCEnergy) {
			CursesandstuffMod.queueServerWork(1, () -> {
				{
					double _setval = (entity.getCapability(CursesandstuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CursesandstuffModVariables.PlayerVariables())).cursedEnergy + 1;
					entity.getCapability(CursesandstuffModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.cursedEnergy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
		}
	}
}
