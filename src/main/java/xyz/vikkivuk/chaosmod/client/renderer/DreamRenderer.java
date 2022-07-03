
package xyz.vikkivuk.chaosmod.client.renderer;

public class DreamRenderer extends HumanoidMobRenderer<DreamEntity, HumanoidModel<DreamEntity>> {

	public DreamRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

	}

	@Override
	public ResourceLocation getTextureLocation(DreamEntity entity) {
		return new ResourceLocation("chaosmod:textures/dream.png");
	}

}
