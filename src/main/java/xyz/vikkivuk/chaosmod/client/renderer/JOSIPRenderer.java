
package xyz.vikkivuk.chaosmod.client.renderer;

import xyz.vikkivuk.chaosmod.entity.JOSIPEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class JOSIPRenderer extends HumanoidMobRenderer<JOSIPEntity, HumanoidModel<JOSIPEntity>> {
	public JOSIPRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new EyesLayer<JOSIPEntity, HumanoidModel<JOSIPEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("chaosmod:textures/entities/422888e8f9292a0c.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JOSIPEntity entity) {
		return new ResourceLocation("chaosmod:textures/entities/422888e8f9292a0c.png");
	}
}
