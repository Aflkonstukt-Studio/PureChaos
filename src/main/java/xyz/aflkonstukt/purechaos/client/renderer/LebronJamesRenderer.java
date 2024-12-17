
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.LebronJamesEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelnextbot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class LebronJamesRenderer extends MobRenderer<LebronJamesEntity, Modelnextbot<LebronJamesEntity>> {
	public LebronJamesRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot<LebronJamesEntity>(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LebronJamesEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/lebron_james_nextbot.png");
	}
}
