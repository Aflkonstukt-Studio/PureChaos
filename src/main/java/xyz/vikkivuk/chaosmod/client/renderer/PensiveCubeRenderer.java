
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.PensiveCubeEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;

public class PensiveCubeRenderer extends MobRenderer<PensiveCubeEntity, SlimeModel<PensiveCubeEntity>> {
	public PensiveCubeRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PensiveCubeEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/pensive_cube.png");
	}
}
