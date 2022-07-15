
package xyz.vikkivuk.chaosmod.client.renderer;

public class Amogus3CrewRenderer extends MobRenderer<Amogus3CrewEntity, Modelamongus_woo<Amogus3CrewEntity>> {

	public Amogus3CrewRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3CrewEntity entity) {
		return new ResourceLocation("chaosmod:textures/mogus.png");
	}

}
