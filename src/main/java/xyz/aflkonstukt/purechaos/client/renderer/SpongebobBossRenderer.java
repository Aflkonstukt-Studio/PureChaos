
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.SpongebobBossEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelspongebob_boss;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SpongebobBossRenderer extends MobRenderer<SpongebobBossEntity, Modelspongebob_boss<SpongebobBossEntity>> {
	public SpongebobBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspongebob_boss<SpongebobBossEntity>(context.bakeLayer(Modelspongebob_boss.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpongebobBossEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/spongebob_boss.png");
	}
}
