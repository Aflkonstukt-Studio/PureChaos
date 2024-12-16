package xyz.aflkonstukt.purechaos.entity.model;

import xyz.aflkonstukt.purechaos.entity.BuddyEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class BuddyModel extends GeoModel<BuddyEntity> {
	@Override
	public ResourceLocation getAnimationResource(BuddyEntity entity) {
		return ResourceLocation.parse("purechaos:animations/buddy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BuddyEntity entity) {
		return ResourceLocation.parse("purechaos:geo/buddy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BuddyEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/" + entity.getTexture() + ".png");
	}

}
