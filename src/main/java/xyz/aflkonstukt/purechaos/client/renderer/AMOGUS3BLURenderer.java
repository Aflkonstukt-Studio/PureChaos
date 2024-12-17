
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.AMOGUS3BLUEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelamongus_woo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class AMOGUS3BLURenderer extends MobRenderer<AMOGUS3BLUEntity, Modelamongus_woo<AMOGUS3BLUEntity>> {
	public AMOGUS3BLURenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo<AMOGUS3BLUEntity>(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AMOGUS3BLUEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/bluamogus.png");
	}
}
