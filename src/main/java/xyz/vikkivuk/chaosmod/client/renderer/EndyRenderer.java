
package xyz.vikkivuk.chaosmod.client.renderer;

public class EndyRenderer extends HumanoidMobRenderer<EndyEntity, HumanoidModel<EndyEntity>> {

	public EndyRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

	}

	@Override
	public ResourceLocation getTextureLocation(EndyEntity entity) {
		return new ResourceLocation("chaosmod:textures/enderman.png");
	}

}
