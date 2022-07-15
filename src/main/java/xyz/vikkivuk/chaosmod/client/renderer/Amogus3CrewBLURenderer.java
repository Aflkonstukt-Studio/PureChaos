
package xyz.vikkivuk.chaosmod.client.renderer;

public class Amogus3CrewBLURenderer extends MobRenderer<Amogus3CrewBLUEntity, Modelamongus_woo<Amogus3CrewBLUEntity>> {

	public Amogus3CrewBLURenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3CrewBLUEntity entity) {
		return new ResourceLocation("chaosmod:textures/bluamogus.png");
	}

}
