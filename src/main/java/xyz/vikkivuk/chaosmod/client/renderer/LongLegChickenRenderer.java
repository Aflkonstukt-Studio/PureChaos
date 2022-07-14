
package xyz.vikkivuk.chaosmod.client.renderer;

public class LongLegChickenRenderer extends MobRenderer<LongLegChickenEntity, Modellong_leg_chicken<LongLegChickenEntity>> {

	public LongLegChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellong_leg_chicken(context.bakeLayer(Modellong_leg_chicken.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(LongLegChickenEntity entity) {
		return new ResourceLocation("chaosmod:textures/long_leg_chicken.png");
	}

}
