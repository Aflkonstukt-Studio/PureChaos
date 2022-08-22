
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.AMOGUS3GRINEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelamongus_woo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class AMOGUS3GRINRenderer extends MobRenderer<AMOGUS3GRINEntity, Modelamongus_woo<AMOGUS3GRINEntity>> {
	public AMOGUS3GRINRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AMOGUS3GRINEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/amogusgrin.png");
	}
}
