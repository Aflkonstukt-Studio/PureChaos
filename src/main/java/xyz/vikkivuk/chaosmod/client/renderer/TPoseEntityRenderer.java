
package xyz.vikkivuk.chaosmod.client.renderer;

public class TPoseEntityRenderer extends MobRenderer<TPoseEntityEntity, Modeltpose_smth<TPoseEntityEntity>> {

	public TPoseEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltpose_smth(context.bakeLayer(Modeltpose_smth.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(TPoseEntityEntity entity) {
		return new ResourceLocation("chaosmod:textures/tpose_smth.png");
	}

}
