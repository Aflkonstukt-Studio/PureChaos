
package xyz.vikkivuk.chaosmod.client.renderer;

public class Amogus3Renderer extends HumanoidMobRenderer<Amogus3Entity, HumanoidModel<Amogus3Entity>> {

	public Amogus3Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3Entity entity) {
		return new ResourceLocation("chaosmod:textures/mogus.png");
	}

}
