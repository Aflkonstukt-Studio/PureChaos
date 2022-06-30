
package xyz.vikkivuk.chaosmod.client.renderer;

public class JosipPetRenderer extends MobRenderer<JosipPetEntity, Modeljosipmmarket<JosipPetEntity>> {

	public JosipPetRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljosipmmarket(context.bakeLayer(Modeljosipmmarket.LAYER_LOCATION)), 0.6f);

		this.addLayer(new EyesLayer<JosipPetEntity, Modeljosipmmarket<JosipPetEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("chaosmod:textures/marketableplush.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JosipPetEntity entity) {
		return new ResourceLocation("chaosmod:textures/marketableplush.png");
	}

}
