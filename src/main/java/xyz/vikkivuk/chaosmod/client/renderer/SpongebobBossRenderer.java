
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.SpongebobBossEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelspongebob_boss;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SpongebobBossRenderer extends MobRenderer<SpongebobBossEntity, Modelspongebob_boss<SpongebobBossEntity>> {
	public SpongebobBossRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspongebob_boss(context.bakeLayer(Modelspongebob_boss.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpongebobBossEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/spongebob_boss.png");
	}
}
