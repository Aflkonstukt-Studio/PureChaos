
package xyz.vikkivuk.chaosmod.client.renderer;

public class LegsRenderer extends MobRenderer<LegsEntity, Modellegs<LegsEntity>> {

	public LegsRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellegs(context.bakeLayer(Modellegs.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(LegsEntity entity) {
		return new ResourceLocation("chaosmod:textures/legs.png");
	}

}
