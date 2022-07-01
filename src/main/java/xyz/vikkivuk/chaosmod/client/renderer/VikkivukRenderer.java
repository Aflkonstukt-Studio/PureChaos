
package xyz.vikkivuk.chaosmod.client.renderer;

public class VikkivukRenderer extends MobRenderer<VikkivukEntity, Modelvikkivuk_plushie<VikkivukEntity>> {

	public VikkivukRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelvikkivuk_plushie(context.bakeLayer(Modelvikkivuk_plushie.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(VikkivukEntity entity) {
		return new ResourceLocation("chaosmod:textures/vikkivuk.png");
	}

}
