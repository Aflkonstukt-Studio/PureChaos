
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.TPoseEntityEntity;
import xyz.aflkonstukt.purechaos.client.model.Modeltpose_smth;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class TPoseEntityRenderer extends MobRenderer<TPoseEntityEntity, Modeltpose_smth<TPoseEntityEntity>> {
	public TPoseEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltpose_smth(context.bakeLayer(Modeltpose_smth.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TPoseEntityEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/tpose_smth.png");
	}
}
