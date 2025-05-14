
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.CursedDogEntity;
import xyz.aflkonstukt.purechaos.client.model.Modeldog;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CursedDogRenderer extends MobRenderer<CursedDogEntity, Modeldog<CursedDogEntity>> {
	public CursedDogRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldog<CursedDogEntity>(context.bakeLayer(Modeldog.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CursedDogEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/cursed_dog_texture.png");
	}
}
