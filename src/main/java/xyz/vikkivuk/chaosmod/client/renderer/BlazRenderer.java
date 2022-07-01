
package xyz.vikkivuk.chaosmod.client.renderer;

public class BlazRenderer extends MobRenderer<BlazEntity, Modelblaze<BlazEntity>> {

	public BlazRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelblaze(context.bakeLayer(Modelblaze.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(BlazEntity entity) {
		return new ResourceLocation("chaosmod:textures/blaze_texture.png");
	}

}
