
package xyz.vikkivuk.chaosmod.client.renderer;

public class Amogus3CrewGRINRenderer extends MobRenderer<Amogus3CrewGRINEntity, Modelamongus_woo<Amogus3CrewGRINEntity>> {

	public Amogus3CrewGRINRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3CrewGRINEntity entity) {
		return new ResourceLocation("chaosmod:textures/amogusgrin.png");
	}

}
