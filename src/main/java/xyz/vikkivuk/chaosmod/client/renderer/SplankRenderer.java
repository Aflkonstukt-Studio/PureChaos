
package xyz.vikkivuk.chaosmod.client.renderer;

public class SplankRenderer extends MobRenderer<SplankEntity, Modelsplank<SplankEntity>> {

	public SplankRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsplank(context.bakeLayer(Modelsplank.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(SplankEntity entity) {
		return new ResourceLocation("chaosmod:textures/splank_texture.png");
	}

}
