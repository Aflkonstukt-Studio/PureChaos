
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.AdolfHitlerEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class AdolfHitlerRenderer extends HumanoidMobRenderer<AdolfHitlerEntity, HumanoidModel<AdolfHitlerEntity>> {
	public AdolfHitlerRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(AdolfHitlerEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/adolf.png");
	}
}
