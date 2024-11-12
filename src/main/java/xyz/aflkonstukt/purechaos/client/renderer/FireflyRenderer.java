
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.FireflyEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelfireflies;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class FireflyRenderer extends MobRenderer<FireflyEntity, Modelfireflies<FireflyEntity>> {
	public FireflyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfireflies(context.bakeLayer(Modelfireflies.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(FireflyEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/fireflies.png");
	}
}
