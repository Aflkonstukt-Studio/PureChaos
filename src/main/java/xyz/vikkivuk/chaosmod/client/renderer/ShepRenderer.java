
package xyz.vikkivuk.chaosmod.client.renderer;

public class ShepRenderer extends MobRenderer<ShepEntity, Modelshep<ShepEntity>> {

	public ShepRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelshep(context.bakeLayer(Modelshep.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(ShepEntity entity) {
		return new ResourceLocation("chaosmod:textures/shep_texture.png");
	}

}
