
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.Amogus2Entity;
import xyz.vikkivuk.chaosmod.client.model.Modelamiogyhus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class Amogus2Renderer extends MobRenderer<Amogus2Entity, Modelamiogyhus<Amogus2Entity>> {
	public Amogus2Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelamiogyhus(context.bakeLayer(Modelamiogyhus.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Amogus2Entity entity) {
		return new ResourceLocation("chaosmod:textures/entities/aaas.png");
	}
}
