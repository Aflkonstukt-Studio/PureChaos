
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
			new Climate.ParameterPoint(Climate.Parameter.span(-1f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.3f, 0.2f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-1f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.3f, 0.2f), 0));

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
