
package xyz.vikkivuk.chaosmod.client.renderer;

public class AmongUsRenderer extends HumanoidMobRenderer<AmongUsEntity, HumanoidModel<AmongUsEntity>> {

	public AmongUsRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

	}

	@Override
	public ResourceLocation getTextureLocation(AmongUsEntity entity) {
		return new ResourceLocation("chaosmod:textures/among_us_biped.png");
	}

}
