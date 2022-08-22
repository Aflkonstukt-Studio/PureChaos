
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.LegsEntity;
import xyz.vikkivuk.chaosmod.client.model.Modellegs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class LegsRenderer extends MobRenderer<LegsEntity, Modellegs<LegsEntity>> {
	public LegsRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellegs(context.bakeLayer(Modellegs.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LegsEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/legs.png");
	}
}
