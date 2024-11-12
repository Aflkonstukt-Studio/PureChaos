
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.LegsEntity;
import xyz.aflkonstukt.purechaos.client.model.Modellegs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class LegsRenderer extends MobRenderer<LegsEntity, Modellegs<LegsEntity>> {
	public LegsRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellegs(context.bakeLayer(Modellegs.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LegsEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/legs.png");
	}
}
