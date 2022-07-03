
package xyz.vikkivuk.chaosmod.client.renderer;

public class AdolfHitlerRenderer extends HumanoidMobRenderer<AdolfHitlerEntity, HumanoidModel<AdolfHitlerEntity>> {

	public AdolfHitlerRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

	}

	@Override
	public ResourceLocation getTextureLocation(AdolfHitlerEntity entity) {
		return new ResourceLocation("chaosmod:textures/adolf.png");
	}

}
