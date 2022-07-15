
package xyz.vikkivuk.chaosmod.client.renderer;

public class AMOGUS3GRINRenderer extends MobRenderer<AMOGUS3GRINEntity, Modelamongus_woo<AMOGUS3GRINEntity>> {

	public AMOGUS3GRINRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(AMOGUS3GRINEntity entity) {
		return new ResourceLocation("chaosmod:textures/amogusgrin.png");
	}

}
