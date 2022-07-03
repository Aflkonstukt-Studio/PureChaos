
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.Amogus3Entity;
import xyz.vikkivuk.chaosmod.client.model.Modelamongus_woo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class Amogus3Renderer extends MobRenderer<Amogus3Entity, Modelamongus_woo<Amogus3Entity>> {
	public Amogus3Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3Entity entity) {
		return new ResourceLocation("chaosmod:textures/mogus.png");
	}
}
