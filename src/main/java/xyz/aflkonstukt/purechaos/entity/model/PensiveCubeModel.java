package xyz.aflkonstukt.purechaos.entity.model;

import xyz.aflkonstukt.purechaos.entity.PensiveCubeEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class PensiveCubeModel extends GeoModel<PensiveCubeEntity> {
	@Override
	public ResourceLocation getAnimationResource(PensiveCubeEntity entity) {
		return new ResourceLocation("purechaos", "animations/pensive_cube.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PensiveCubeEntity entity) {
		return new ResourceLocation("purechaos", "geo/pensive_cube.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PensiveCubeEntity entity) {
		return new ResourceLocation("purechaos", "textures/entities/" + entity.getTexture() + ".png");
	}

}
