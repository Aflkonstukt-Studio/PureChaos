
package xyz.vikkivuk.chaosmod.client.renderer;

public class MothOfAggrevationRenderer extends MobRenderer<MothOfAggrevationEntity, Modelmoth<MothOfAggrevationEntity>> {

	public MothOfAggrevationRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmoth(context.bakeLayer(Modelmoth.LAYER_LOCATION)), 0.3f);

	}

	@Override
	public ResourceLocation getTextureLocation(MothOfAggrevationEntity entity) {
		return new ResourceLocation("chaosmod:textures/moth.png");
	}

}
