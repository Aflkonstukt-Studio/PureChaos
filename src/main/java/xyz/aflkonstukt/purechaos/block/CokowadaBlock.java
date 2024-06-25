
package xyz.aflkonstukt.purechaos.block;

import xyz.aflkonstukt.purechaos.init.PurechaosModFluids;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

public class CokowadaBlock extends LiquidBlock {
	public CokowadaBlock() {
		super(() -> PurechaosModFluids.COKOWADA.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}
