
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.TPoseEntityEntity;
import xyz.vikkivuk.chaosmod.client.model.Modeltpose_smth;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class TPoseEntityRenderer extends MobRenderer<TPoseEntityEntity, Modeltpose_smth<TPoseEntityEntity>> {
	public TPoseEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltpose_smth(context.bakeLayer(Modeltpose_smth.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TPoseEntityEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/tpose_smth.png");
	}
}
