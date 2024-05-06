package xyz.aflkonstukt.purechaos.client.model;
// Made with Blockbench 4.9.4

// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class Modelgroggo<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("purechaos", "modelgroggo"), "main");
	public final ModelPart bb_main;

	public Modelgroggo(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(27, 14).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(10, 24).addBox(1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(19, 0).addBox(-2.0F, -1.0F, 1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 28)
						.addBox(-2.0F, -3.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 4).addBox(1.0F, -3.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.0F, -3.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.0F, -6.0F, -4.0F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(21, 19).addBox(-2.5F, -11.0F, -7.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-1.5F, -9.0F, -4.5F, 4.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 17).addBox(-2.5F, -14.0F, -6.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 5)
						.addBox(1.5F, -14.0F, -6.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(17, 14).addBox(-1.0F, -8.0F, -9.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(21, 4).addBox(-0.5F, -9.2238F, 0.9397F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, 0.5672F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
