
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.CupcakkeEntity;
import xyz.vikkivuk.chaosmod.client.model.Modelthe_rock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CupcakkeRenderer extends MobRenderer<CupcakkeEntity, Modelthe_rock<CupcakkeEntity>> {
	public CupcakkeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelthe_rock(context.bakeLayer(Modelthe_rock.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CupcakkeEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/cupcakke.png");
	}
}
