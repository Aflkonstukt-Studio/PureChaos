
package xyz.vikkivuk.chaosmod.client.renderer;

public class FireflyRenderer extends MobRenderer<FireflyEntity, Modelfireflies<FireflyEntity>> {

	public FireflyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfireflies(context.bakeLayer(Modelfireflies.LAYER_LOCATION)), 0.1f);

	}

	@Override
	public ResourceLocation getTextureLocation(FireflyEntity entity) {
		return new ResourceLocation("chaosmod:textures/fireflies.png");
	}

}
