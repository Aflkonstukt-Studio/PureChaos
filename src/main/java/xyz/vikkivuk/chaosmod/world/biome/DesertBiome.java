
package xyz.vikkivuk.chaosmod.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;

import java.util.List;

public class DesertBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(0.4f, 1.6f), Climate.Parameter.span(-1.6f, -0.4f), Climate.Parameter.span(-0.08999999999999997f, 1.1099999999999999f), Climate.Parameter.span(0.20000000000000007f, 1.4f),
					Climate.Parameter.point(0.0f), Climate.Parameter.span(-1.5970725365240388f, -0.39707253652403873f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(0.4f, 1.6f), Climate.Parameter.span(-1.6f, -0.4f), Climate.Parameter.span(-0.08999999999999997f, 1.1099999999999999f), Climate.Parameter.span(0.20000000000000007f, 1.4f),
					Climate.Parameter.point(1.0f), Climate.Parameter.span(-1.5970725365240388f, -0.39707253652403873f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-154).waterColor(-10079488).waterFogColor(-10079488).skyColor(-154).foliageColorOverride(10387789).grassColorOverride(9470285).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).temperature(2f).downfall(0f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenerationSettings.build()).build();
	}
}
