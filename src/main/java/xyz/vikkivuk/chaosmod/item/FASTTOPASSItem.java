
package xyz.vikkivuk.chaosmod.item;

import xyz.vikkivuk.chaosmod.procedures.FASTTOPASSRightclickedProcedure;
import xyz.vikkivuk.chaosmod.init.ChaosmodModTabs;
import xyz.vikkivuk.chaosmod.init.ChaosmodModSounds;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class FASTTOPASSItem extends RecordItem {
	public FASTTOPASSItem() {
		super(0, ChaosmodModSounds.REGISTRY.get(new ResourceLocation("chaosmod:ahdude")), new Item.Properties().tab(ChaosmodModTabs.TAB_CHAOSTAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("HEHE"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		FASTTOPASSRightclickedProcedure.execute(entity);
		return ar;
	}
}
