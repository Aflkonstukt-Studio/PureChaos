
package xyz.vikkivuk.chaosmod.client.renderer;

public class SpongebobBossRenderer extends MobRenderer<SpongebobBossEntity, Modelspongebob_boss<SpongebobBossEntity>> {

	public SpongebobBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspongebob_boss(context.bakeLayer(Modelspongebob_boss.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(SpongebobBossEntity entity) {
		return new ResourceLocation("chaosmod:textures/spongebob_boss.png");
	}

}
