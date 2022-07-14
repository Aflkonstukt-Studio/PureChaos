
package xyz.vikkivuk.chaosmod.client.renderer;

public class RickAstleyRenderer extends HumanoidMobRenderer<RickAstleyEntity, HumanoidModel<RickAstleyEntity>> {

	public RickAstleyRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

	}

	@Override
	public ResourceLocation getTextureLocation(RickAstleyEntity entity) {
		return new ResourceLocation("chaosmod:textures/rickroll_skin.png");
	}

}
