
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.YugoslaviaEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelnextbot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class YugoslaviaRenderer extends MobRenderer<YugoslaviaEntity, Modelnextbot<YugoslaviaEntity>> {
	public YugoslaviaRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(YugoslaviaEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/squareoslavia.png");
	}
}
