
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.AMOGUS3GRINEntity;
import xyz.aflkonstukt.purechaos.client.model.Modelamongus_woo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class AMOGUS3GRINRenderer extends MobRenderer<AMOGUS3GRINEntity, Modelamongus_woo<AMOGUS3GRINEntity>> {
	public AMOGUS3GRINRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AMOGUS3GRINEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/amogusgrin.png");
	}
}
