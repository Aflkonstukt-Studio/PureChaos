package xyz.aflkonstukt.purechaos.entity.model;

import xyz.aflkonstukt.purechaos.entity.BalloonEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class BalloonModel extends GeoModel<BalloonEntity> {
	@Override
	public ResourceLocation getAnimationResource(BalloonEntity entity) {
		return ResourceLocation.parse("purechaos:animations/balloon.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BalloonEntity entity) {
		return ResourceLocation.parse("purechaos:geo/balloon.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BalloonEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/" + entity.getTexture() + ".png");
	}

}
