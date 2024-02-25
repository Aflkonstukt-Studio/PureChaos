
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.JosipPettEntity;
import xyz.aflkonstukt.purechaos.client.model.Modeljosipmmarket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class JosipPettRenderer extends MobRenderer<JosipPettEntity, Modeljosipmmarket<JosipPettEntity>> {
	public JosipPettRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljosipmmarket(context.bakeLayer(Modeljosipmmarket.LAYER_LOCATION)), 0.6f);
		this.addLayer(new RenderLayer<JosipPettEntity, Modeljosipmmarket<JosipPettEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("purechaos:textures/entities/mamavoilibebunajvisenasvjetttuunajvisenakurcumamaubijabebu.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, JosipPettEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, 15728640, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JosipPettEntity entity) {
		return new ResourceLocation("purechaos:textures/entities/mamavoilibebunajvisenasvjetttuunajvisenakurcumamaubijabebu.png");
	}
}
