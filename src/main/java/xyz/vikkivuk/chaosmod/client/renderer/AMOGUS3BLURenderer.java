
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.AMOGUS3BLUEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelamongus_woo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class AMOGUS3BLURenderer extends MobRenderer<AMOGUS3BLUEntity, Modelamongus_woo<AMOGUS3BLUEntity>> {
	public AMOGUS3BLURenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AMOGUS3BLUEntity entity) {
		return new ResourceLocation("chaosmod:textures/bluamogus.png");
	}
}
