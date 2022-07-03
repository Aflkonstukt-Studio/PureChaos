
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.MothOfAggrevationEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelmoth;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class MothOfAggrevationRenderer extends MobRenderer<MothOfAggrevationEntity, Modelmoth<MothOfAggrevationEntity>> {
	public MothOfAggrevationRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmoth(context.bakeLayer(Modelmoth.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(MothOfAggrevationEntity entity) {
		return new ResourceLocation("chaosmod:textures/moth.png");
	}
}
