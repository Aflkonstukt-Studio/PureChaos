
package xyz.vikkivuk.chaosmod.client.renderer;

public class Amogus3Renderer extends MobRenderer<Amogus3Entity, Modelcustom_model<Amogus3Entity>> {

	public Amogus3Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3Entity entity) {
		return new ResourceLocation("chaosmod:textures/mogus.png");
	}

}
