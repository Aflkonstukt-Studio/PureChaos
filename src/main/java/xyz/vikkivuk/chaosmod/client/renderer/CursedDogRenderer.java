
package xyz.vikkivuk.chaosmod.client.renderer;

public class CursedDogRenderer extends MobRenderer<CursedDogEntity, Modeldog<CursedDogEntity>> {

	public CursedDogRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldog(context.bakeLayer(Modeldog.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(CursedDogEntity entity) {
		return new ResourceLocation("chaosmod:textures/cursed_dog_texture.png");
	}

}
