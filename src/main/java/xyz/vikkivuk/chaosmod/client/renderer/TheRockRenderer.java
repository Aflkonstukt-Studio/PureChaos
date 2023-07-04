
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.TheRockEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelnextbot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class TheRockRenderer extends MobRenderer<TheRockEntity, Modelnextbot<TheRockEntity>> {
	public TheRockRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TheRockEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/the_rock.png");
	}
}
