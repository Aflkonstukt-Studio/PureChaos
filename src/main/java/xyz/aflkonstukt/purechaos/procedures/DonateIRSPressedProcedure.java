package xyz.aflkonstukt.purechaos.procedures;

import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;
import java.util.Map;

public class DonateIRSPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double add_karma = 0;
		add_karma = add_karma + getAmountInGUISlot(entity, 0);
		add_karma = add_karma + getAmountInGUISlot(entity, 1);
		add_karma = add_karma + getAmountInGUISlot(entity, 2);
		add_karma = add_karma + getAmountInGUISlot(entity, 3);
		add_karma = add_karma + getAmountInGUISlot(entity, 4);
		add_karma = add_karma + getAmountInGUISlot(entity, 5);
		add_karma = add_karma + getAmountInGUISlot(entity, 6);
		add_karma = add_karma + getAmountInGUISlot(entity, 7);
		add_karma = add_karma + getAmountInGUISlot(entity, 8);
		{
			PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
			_vars.karma = entity.getData(PurechaosModVariables.PLAYER_VARIABLES).karma + add_karma / 30;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("You got: " + add_karma / 30 + " karma!")), true);
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier slotSupplier && slotSupplier.get() instanceof Map guiSlots) {
			ItemStack stack = ((Slot) guiSlots.get(sltid)).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}
