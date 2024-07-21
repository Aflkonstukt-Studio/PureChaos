package xyz.aflkonstukt.purechaos.entity.model;

import xyz.aflkonstukt.purechaos.entity.PensiveCubesEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class PensiveCubesModel extends GeoModel<PensiveCubesEntity> {
	@Override
	public ResourceLocation getAnimationResource(PensiveCubesEntity entity) {
		return new ResourceLocation("purechaos", "animations/pensive_cube.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PensiveCubesEntity entity) {
		return new ResourceLocation("purechaos", "geo/pensive_cube.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PensiveCubesEntity entity) {
		return new ResourceLocation("purechaos", "textures/entities/" + entity.getTexture() + ".png");
	}

}
