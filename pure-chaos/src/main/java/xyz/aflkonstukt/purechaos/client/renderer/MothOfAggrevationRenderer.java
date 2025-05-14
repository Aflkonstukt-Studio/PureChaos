
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.MothOfAggrevationEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelmoth;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class MothOfAggrevationRenderer extends MobRenderer<MothOfAggrevationEntity, Modelmoth<MothOfAggrevationEntity>> {
	public MothOfAggrevationRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmoth<MothOfAggrevationEntity>(context.bakeLayer(Modelmoth.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(MothOfAggrevationEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/moth.png");
	}
}
