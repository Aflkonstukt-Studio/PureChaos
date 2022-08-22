
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.TridentEntity;
import xyz.vikkivuk.chaosmod.client.model.Modeltrident;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class TridentRenderer extends MobRenderer<TridentEntity, Modeltrident<TridentEntity>> {
	public TridentRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltrident(context.bakeLayer(Modeltrident.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TridentEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/trident_texture.png");
	}
}
