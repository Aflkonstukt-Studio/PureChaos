
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.ShepEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelshep;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ShepRenderer extends MobRenderer<ShepEntity, Modelshep<ShepEntity>> {
	public ShepRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelshep<ShepEntity>(context.bakeLayer(Modelshep.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ShepEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/shep_texture.png");
	}
}
