
package xyz.vikkivuk.chaosmod.client.renderer;

public class CodButBetterRenderer extends MobRenderer<CodButBetterEntity, Modelcod_but_better<CodButBetterEntity>> {

	public CodButBetterRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcod_but_better(context.bakeLayer(Modelcod_but_better.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(CodButBetterEntity entity) {
		return new ResourceLocation("chaosmod:textures/cod_but_better.png");
	}

}
