
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.CodButBetterEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelcod_but_better;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CodButBetterRenderer extends MobRenderer<CodButBetterEntity, Modelcod_but_better<CodButBetterEntity>> {
	public CodButBetterRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcod_but_better(context.bakeLayer(Modelcod_but_better.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CodButBetterEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/cod_but_better.png");
	}
}
