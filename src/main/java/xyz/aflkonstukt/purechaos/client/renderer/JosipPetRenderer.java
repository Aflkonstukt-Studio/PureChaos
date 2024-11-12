
package xyz.aflkonstukt.purechaos.client.renderer;

import xyz.aflkonstukt.purechaos.entity.JosipPetEntity;
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

public class JosipPetRenderer extends MobRenderer<JosipPetEntity, Modeljosipmmarket<JosipPetEntity>> {
	public JosipPetRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljosipmmarket(context.bakeLayer(Modeljosipmmarket.LAYER_LOCATION)), 0.6f);
		this.addLayer(new RenderLayer<JosipPetEntity, Modeljosipmmarket<JosipPetEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("purechaos:textures/entities/josip_pet_updated_do_not_remove.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, JosipPetEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(JosipPetEntity entity) {
		return ResourceLocation.parse("purechaos:textures/entities/josip_pet_updated_do_not_remove.png");
	}
}
