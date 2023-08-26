
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.JosipPetEntity;
import xyz.aflkonstukt.purechaos.client.model.Modeljosipmmarket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class JosipPetRenderer extends MobRenderer<JosipPetEntity, Modeljosipmmarket<JosipPetEntity>> {
	public JosipPetRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljosipmmarket(context.bakeLayer(Modeljosipmmarket.LAYER_LOCATION)), 0.6f);
		this.addLayer(new EyesLayer<JosipPetEntity, Modeljosipmmarket<JosipPetEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("purechaos:textures/entities/josip_pet_updated_do_not_remove.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JosipPetEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/josip_pet_updated_do_not_remove.png");
	}
}
