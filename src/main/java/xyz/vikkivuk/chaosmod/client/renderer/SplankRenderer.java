
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.SplankEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelsplank;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SplankRenderer extends MobRenderer<SplankEntity, Modelsplank<SplankEntity>> {
	public SplankRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsplank(context.bakeLayer(Modelsplank.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SplankEntity entity) {
		return new ResourceLocation("chaosmod:textures/splank_texture.png");
	}
}
