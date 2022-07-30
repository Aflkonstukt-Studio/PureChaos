
package xyz.vikkivuk.chaosmod.client.renderer;

public class TheRockRenderer extends MobRenderer<TheRockEntity, Modelthe_rock<TheRockEntity>> {

	public TheRockRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelthe_rock(context.bakeLayer(Modelthe_rock.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(TheRockEntity entity) {
		return new ResourceLocation("chaosmod:textures/the_rock.png");
	}

}
