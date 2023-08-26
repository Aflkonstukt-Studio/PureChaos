
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.StroaterEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelstroater;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class StroaterRenderer extends MobRenderer<StroaterEntity, Modelstroater<StroaterEntity>> {
	public StroaterRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstroater(context.bakeLayer(Modelstroater.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StroaterEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/stroater.png");
	}
}
