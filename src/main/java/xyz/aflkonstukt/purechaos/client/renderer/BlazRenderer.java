
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.BlazEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelblaze;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BlazRenderer extends MobRenderer<BlazEntity, Modelblaze<BlazEntity>> {
	public BlazRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelblaze(context.bakeLayer(Modelblaze.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlazEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/blaze_texture.png");
	}
}
