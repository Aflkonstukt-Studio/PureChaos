
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.TheRockEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelnextbot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class TheRockRenderer extends MobRenderer<TheRockEntity, Modelnextbot<TheRockEntity>> {
	public TheRockRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TheRockEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/the_rock.png");
	}
}
