
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.BaldiMinusEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelbaldi;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BaldiMinusRenderer extends MobRenderer<BaldiMinusEntity, Modelbaldi<BaldiMinusEntity>> {
	public BaldiMinusRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbaldi(context.bakeLayer(Modelbaldi.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BaldiMinusEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/texture.png");
	}
}
