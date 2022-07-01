
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.CursedDogEntity;
import xyz.vikkivuk.chaosmod.client.model.Modeldog;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CursedDogRenderer extends MobRenderer<CursedDogEntity, Modeldog<CursedDogEntity>> {
	public CursedDogRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldog(context.bakeLayer(Modeldog.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CursedDogEntity entity) {
		return new ResourceLocation("chaosmod:textures/cursed_dog_texture.png");
	}
}
