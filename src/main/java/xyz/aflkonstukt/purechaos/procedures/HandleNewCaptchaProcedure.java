package xyz.aflkonstukt.purechaos.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import xyz.aflkonstukt.purechaos.world.inventory.CaptchaGUIMenu;
import xyz.aflkonstukt.purechaos.network.PurechaosModVariables;
import xyz.aflkonstukt.purechaos.init.PurechaosModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;


public class HandleNewCaptchaProcedure {
	public static boolean isSinglePlayer()
	{
		try
		{
			if(Minecraft.getInstance().getSingleplayerServer() != null)
			{
				return Minecraft.getInstance().getSingleplayerServer().isSingleplayer();
			}
			return false;
		}
		catch( Exception e ) // Server is null, not started
		{
			return false;
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		GenerateCaptchaProcedure.execute(entity);
		if (isSinglePlayer()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("CaptchaGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new CaptchaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.captcha = true;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				PurechaosModVariables.PlayerVariables _vars = entity.getData(PurechaosModVariables.PLAYER_VARIABLES);
				_vars.text_captcha = 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
