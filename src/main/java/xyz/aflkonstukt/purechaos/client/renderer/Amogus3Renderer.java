
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.Amogus3Entity;
import xyz.aflkonstukt.purechaos.client.model.Modelamongus_woo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class Amogus3Renderer extends MobRenderer<Amogus3Entity, Modelamongus_woo<Amogus3Entity>> {
	public Amogus3Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3Entity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/mogus.png");
	}
}
