
package xyz.aflkonstukt.purechaos.world.features;

import xyz.aflkonstukt.purechaos.world.features.configurations.StructureFeatureConfiguration;
import xyz.aflkonstukt.purechaos.procedures.HECFeatureAdditionalGenerationConditionProcedure;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class HECFeatureFeature extends StructureFeature {
	public HECFeatureFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!HECFeatureAdditionalGenerationConditionProcedure.execute(world))
			return false;
		return super.place(context);
	}
}
