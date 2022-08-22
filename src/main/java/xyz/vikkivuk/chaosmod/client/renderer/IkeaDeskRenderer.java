
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.IkeaDeskEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelikea_desk;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class IkeaDeskRenderer extends MobRenderer<IkeaDeskEntity, Modelikea_desk<IkeaDeskEntity>> {
	public IkeaDeskRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelikea_desk(context.bakeLayer(Modelikea_desk.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(IkeaDeskEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/ikea_desk_texture.png");
	}
}
