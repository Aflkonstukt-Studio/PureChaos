
package xyz.vikkivuk.chaosmod.client.renderer;

public class JOSIPRenderer extends HumanoidMobRenderer<JOSIPEntity, HumanoidModel<JOSIPEntity>> {

	public JOSIPRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

		this.addLayer(new EyesLayer<JOSIPEntity, HumanoidModel<JOSIPEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("chaosmod:textures/422888e8f9292a0c.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JOSIPEntity entity) {
		return new ResourceLocation("chaosmod:textures/422888e8f9292a0c.png");
	}

}
