package xyz.vikkivuk.chaosmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class TesticleOnStickRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		{
			BlockPos _bp = new BlockPos(x, y, z);
			BlockState _bs = ChaosmodModBlocks.CUM.get().defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
				if (_property != null && _bs.getValue(_property) != null)
					try {
						_bs = _bs.setValue(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			BlockEntity _be = world.getBlockEntity(_bp);
			CompoundTag _bnbt = null;
			if (_be != null) {
				_bnbt = _be.saveWithFullMetadata();
				_be.setRemoved();
			}
			world.setBlock(_bp, _bs, 3);
			if (_bnbt != null) {
				_be = world.getBlockEntity(_bp);
				if (_be != null) {
					try {
						_be.load(_bnbt);
					} catch (Exception ignored) {
					}
				}
			}
		}
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
	}
}
