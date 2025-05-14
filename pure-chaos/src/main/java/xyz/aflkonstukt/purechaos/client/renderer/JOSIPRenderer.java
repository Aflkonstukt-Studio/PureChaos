
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.JOSIPEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JOSIPRenderer extends HumanoidMobRenderer<JOSIPEntity, HumanoidModel<JOSIPEntity>> {
	public JOSIPRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<JOSIPEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<JOSIPEntity, HumanoidModel<JOSIPEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("purechaos:textures/entities/422888e8f9292a0c.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, JOSIPEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JOSIPEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/422888e8f9292a0c.png");
	}
}
