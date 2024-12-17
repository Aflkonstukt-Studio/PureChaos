
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.CupcakkeEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelnextbot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CupcakkeRenderer extends MobRenderer<CupcakkeEntity, Modelnextbot<CupcakkeEntity>> {
	public CupcakkeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot<CupcakkeEntity>(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CupcakkeEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/cupcakke.png");
	}
}
