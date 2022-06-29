
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.Amogus3Entity;
import xyz.vikkivuk.chaosmod.client.model.Modelcustom_model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class Amogus3Renderer extends MobRenderer<Amogus3Entity, Modelcustom_model<Amogus3Entity>> {
	public Amogus3Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3Entity entity) {
		return new ResourceLocation("chaosmod:textures/mogus.png");
	}
}
