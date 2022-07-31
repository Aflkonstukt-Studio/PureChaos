
package xyz.vikkivuk.chaosmod.client.renderer;

public class BigRenderer extends MobRenderer<BigEntity, PigModel<BigEntity>> {

	public BigRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel(context.bakeLayer(ModelLayers.PIG)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(BigEntity entity) {
		return new ResourceLocation("chaosmod:textures/big_texture.png");
	}

}
