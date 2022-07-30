
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.TheRockEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelthe_rock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class TheRockRenderer extends MobRenderer<TheRockEntity, Modelthe_rock<TheRockEntity>> {
	public TheRockRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelthe_rock(context.bakeLayer(Modelthe_rock.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TheRockEntity entity) {
		return new ResourceLocation("chaosmod:textures/the_rock.png");
	}
}
