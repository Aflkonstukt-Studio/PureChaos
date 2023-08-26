
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.LongLegChickenEntity;
import xyz.aflkonstukt.purechaos.client.model.Modellong_leg_chicken;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class LongLegChickenRenderer extends MobRenderer<LongLegChickenEntity, Modellong_leg_chicken<LongLegChickenEntity>> {
	public LongLegChickenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellong_leg_chicken(context.bakeLayer(Modellong_leg_chicken.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LongLegChickenEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/long_leg_chicken.png");
	}
}
