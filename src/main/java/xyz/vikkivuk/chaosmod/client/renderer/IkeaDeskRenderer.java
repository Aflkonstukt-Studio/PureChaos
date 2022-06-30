
package xyz.vikkivuk.chaosmod.client.renderer;

public class IkeaDeskRenderer extends MobRenderer<IkeaDeskEntity, Modelikea_desk<IkeaDeskEntity>> {

	public IkeaDeskRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelikea_desk(context.bakeLayer(Modelikea_desk.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(IkeaDeskEntity entity) {
		return new ResourceLocation("chaosmod:textures/ikea_desk_texture.png");
	}

}
