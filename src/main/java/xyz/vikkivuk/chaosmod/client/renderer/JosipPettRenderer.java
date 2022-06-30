
package xyz.vikkivuk.chaosmod.client.renderer;

public class JosipPettRenderer extends MobRenderer<JosipPettEntity, Modeljosipmmarket<JosipPettEntity>> {

	public JosipPettRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljosipmmarket(context.bakeLayer(Modeljosipmmarket.LAYER_LOCATION)), 0.6f);

		this.addLayer(new EyesLayer<JosipPettEntity, Modeljosipmmarket<JosipPettEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("chaosmod:textures/mamavoilibebunajvisenasvjetttuunajvisenakurcumamaubijabebu.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JosipPettEntity entity) {
		return new ResourceLocation("chaosmod:textures/mamavoilibebunajvisenasvjetttuunajvisenakurcumamaubijabebu.png");
	}

}
