
package xyz.vikkivuk.chaosmod.client.renderer;

public class AentityRenderer extends HumanoidMobRenderer<AentityEntity, HumanoidModel<AentityEntity>> {

	public AentityRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

		this.addLayer(new EyesLayer<AentityEntity, HumanoidModel<AentityEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("chaosmod:textures/rick_kurac.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AentityEntity entity) {
		return new ResourceLocation("chaosmod:textures/char.png");
	}

}
