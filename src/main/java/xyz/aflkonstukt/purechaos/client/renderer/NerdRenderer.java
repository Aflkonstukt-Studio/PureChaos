
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.NerdEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelnextbot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class NerdRenderer extends MobRenderer<NerdEntity, Modelnextbot<NerdEntity>> {
	public NerdRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(NerdEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/nerd.png");
	}
}
