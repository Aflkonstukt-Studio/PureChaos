package xyz.aflkonstukt.purechaos.client.model;
// Made with Blockbench 4.0.3

// Exported for Minecraft version 1.17 with Mojang mappings
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

public class Modelamongus_woo<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("purechaos", "modelamongus_woo"), "main");
	public final ModelPart bb_main;

	public Modelamongus_woo(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 28).addBox(1.0F, -5.0F, -1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 28).mirror().addBox(-5.0F, -5.0F, -1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, 0).addBox(-5.0F, -19.0F, -1.0F, 10.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(46, 0).addBox(-4.0F, -17.0F, -1.25F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 5)
						.addBox(-4.0F, -18.0F, 2.25F, 8.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int rgb) {
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
