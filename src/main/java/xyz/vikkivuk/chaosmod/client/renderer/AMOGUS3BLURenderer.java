
package xyz.vikkivuk.chaosmod.client.renderer;

public class AMOGUS3BLURenderer extends MobRenderer<AMOGUS3BLUEntity, Modelamongus_woo<AMOGUS3BLUEntity>> {

	public AMOGUS3BLURenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(AMOGUS3BLUEntity entity) {
		return new ResourceLocation("chaosmod:textures/bluamogus.png");
	}

}
