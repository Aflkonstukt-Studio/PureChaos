
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.MeteorEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelmeteor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class MeteorRenderer extends MobRenderer<MeteorEntity, Modelmeteor<MeteorEntity>> {
	public MeteorRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmeteor<MeteorEntity>(context.bakeLayer(Modelmeteor.LAYER_LOCATION)), 16f);
	}

	@Override
	public ResourceLocation getTextureLocation(MeteorEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/coal-modified.png");
	}
}
