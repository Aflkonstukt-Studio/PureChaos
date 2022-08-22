
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.VikkivukEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelvikkivuk_plushie;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class VikkivukRenderer extends MobRenderer<VikkivukEntity, Modelvikkivuk_plushie<VikkivukEntity>> {
	public VikkivukRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelvikkivuk_plushie(context.bakeLayer(Modelvikkivuk_plushie.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(VikkivukEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/vikkivuk.png");
	}
}
