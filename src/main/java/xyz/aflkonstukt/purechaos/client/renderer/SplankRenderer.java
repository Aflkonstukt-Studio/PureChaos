
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.SplankEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelsplank;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SplankRenderer extends MobRenderer<SplankEntity, Modelsplank<SplankEntity>> {
	public SplankRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsplank(context.bakeLayer(Modelsplank.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SplankEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/splank_texture.png");
	}
}
