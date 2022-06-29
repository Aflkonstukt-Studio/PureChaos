
package xyz.vikkivuk.chaosmod.client.renderer;

public class Amogus2Renderer extends MobRenderer<Amogus2Entity, Modelcustom_model<Amogus2Entity>> {

	public Amogus2Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(Amogus2Entity entity) {
		return new ResourceLocation("chaosmod:textures/mogus.png");
	}

}
