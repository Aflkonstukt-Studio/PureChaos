
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.BaldiMinusEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelbaldi;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BaldiMinusRenderer extends MobRenderer<BaldiMinusEntity, Modelbaldi<BaldiMinusEntity>> {
	public BaldiMinusRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbaldi<BaldiMinusEntity>(context.bakeLayer(Modelbaldi.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BaldiMinusEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/texture.png");
	}
}
