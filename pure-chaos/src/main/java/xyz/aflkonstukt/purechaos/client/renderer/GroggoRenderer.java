
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.GroggoEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelgroggo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GroggoRenderer extends MobRenderer<GroggoEntity, Modelgroggo<GroggoEntity>> {
	public GroggoRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgroggo<GroggoEntity>(context.bakeLayer(Modelgroggo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GroggoEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/groggo.png");
	}
}
