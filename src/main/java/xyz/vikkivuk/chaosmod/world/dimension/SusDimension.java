
package xyz.vikkivuk.chaosmod.world.dimension;

@Mod.EventBusSubscriber
public class SusDimension {

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class Fixers {

		@SubscribeEvent
		public static void registerFillerBlocks(FMLCommonSetupEvent event) {
			Set<Block> replaceableBlocks = new HashSet<>();
			replaceableBlocks.add(ChaosmodModBlocks.SUS_BLOCK.get());

			replaceableBlocks.add(Blocks.NETHERRACK);
			replaceableBlocks.add(Blocks.NETHERRACK);

			event.enqueueWork(() -> {
				WorldCarver.CAVE.replaceableBlocks = new ImmutableSet.Builder<Block>().addAll(WorldCarver.CAVE.replaceableBlocks)
						.addAll(replaceableBlocks).build();

				WorldCarver.CANYON.replaceableBlocks = new ImmutableSet.Builder<Block>().addAll(WorldCarver.CANYON.replaceableBlocks)
						.addAll(replaceableBlocks).build();
			});
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void registerDimensionSpecialEffects(FMLClientSetupEvent event) {
			DimensionSpecialEffects customEffect = new DimensionSpecialEffects(128, true, DimensionSpecialEffects.SkyType.NORMAL, false, false) {

				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return new Vec3(1, 0.2, 1);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return true;
				}

			};

			event.enqueueWork(() -> DimensionSpecialEffects.EFFECTS.put(new ResourceLocation("chaosmod:sus"), customEffect));
		}

	}

}
