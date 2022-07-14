
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.Amogus3CrewGRINEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelamongus_woo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class Amogus3CrewGRINRenderer extends MobRenderer<Amogus3CrewGRINEntity, Modelamongus_woo<Amogus3CrewGRINEntity>> {
	public Amogus3CrewGRINRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3CrewGRINEntity entity) {
		return new ResourceLocation("chaosmod:textures/amogusgrin.png");
	}
}
