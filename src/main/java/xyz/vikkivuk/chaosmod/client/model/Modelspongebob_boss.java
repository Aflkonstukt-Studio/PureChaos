package xyz.vikkivuk.chaosmod.client.model;

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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelspongebob_boss<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("chaosmod", "modelspongebob_boss"), "main");
	public final ModelPart eyes;
	public final ModelPart arms;
	public final ModelPart legs;
	public final ModelPart bb_main;

	public Modelspongebob_boss(ModelPart root) {
		this.eyes = root.getChild("eyes");
		this.arms = root.getChild("arms");
		this.legs = root.getChild("legs");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition eyes = partdefinition
				.addOrReplaceChild("eyes",
						CubeListBuilder.create().texOffs(10, 33).addBox(-5.0F, -23.0F, -3.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
								.texOffs(0, 33).addBox(1.0F, -23.0F, -3.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition arms = partdefinition.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition left_hand = arms.addOrReplaceChild("left_hand",
				CubeListBuilder.create().texOffs(33, 27).addBox(7.0F, -17.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 29)
						.addBox(10.0F, -17.0F, -2.25F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(20, 33)
						.addBox(11.0F, -17.0F, -0.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 35)
						.addBox(11.0F, -17.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 34)
						.addBox(11.0F, -17.0F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 15)
						.addBox(9.0F, -23.0F, -3.3F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 0.0F, 0.0F));
		PartDefinition right_hand = arms.addOrReplaceChild("right_hand",
				CubeListBuilder.create().texOffs(30, 13).addBox(7.0F, -17.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(30, 6)
						.addBox(10.0F, -17.0F, -2.25F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(30, 11)
						.addBox(11.0F, -17.0F, -0.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(27, 0)
						.addBox(11.0F, -17.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 24)
						.addBox(11.0F, -17.0F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 21).addBox(9.0F, -23.0F, -3.3F, 6.0F,
								6.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(5.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = left_leg.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(30, 6).addBox(-3.0F, -4.0F, 2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
						.addBox(-3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 27).addBox(-4.0F, -7.0F, 1.0F, 3.0F,
								3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r2 = right_leg.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(28, 33).addBox(-3.0F, -4.0F, 2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 21)
						.addBox(-3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 0).addBox(-4.0F, -7.0F, 1.0F, 3.0F, 3.0F,
								3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition bb_main = partdefinition.addOrReplaceChild(
				"bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -25.0F, -2.0F, 12.0F, 18.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(0, 24).addBox(-0.5F, -19.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		eyes.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arms.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
