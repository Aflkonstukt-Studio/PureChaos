
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.Amogus3CrewBLUEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelamongus_woo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class Amogus3CrewBLURenderer extends MobRenderer<Amogus3CrewBLUEntity, Modelamongus_woo<Amogus3CrewBLUEntity>> {
	public Amogus3CrewBLURenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongus_woo(context.bakeLayer(Modelamongus_woo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Amogus3CrewBLUEntity entity) {
		return new ResourceLocation("chaosmod:textures/bluamogus.png");
	}
}
