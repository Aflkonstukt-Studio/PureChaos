// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelvikkivuk_plushie<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "vikkivuk_plushie"), "main");
	private final ModelPart bb_main;

	public Modelvikkivuk_plushie(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 14)
				.addBox(-2.0F, -4.0F, 0.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(14, 15)
						.addBox(-2.0F, -1.0F, 2.1F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(18, 0)
						.addBox(-2.0F, -1.0F, -2.1F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, 1.4835F, 1.4835F, 1.5708F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(18, 1)
						.addBox(-2.0F, -1.0F, 2.1F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(18, 2)
						.addBox(-2.0F, -1.0F, -2.1F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 7)
						.addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, 0.0869F, -0.0076F, 0.0869F));

		PartDefinition cube_r3 = bb_main
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(8, 15).addBox(0.75F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r4 = bb_main
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(14, 16).addBox(-1.25F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -4.0F, 1.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -4.0F, 1.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(12, 7).addBox(-2.0F, -5.3F, -1.0F, 2.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, 0.0779F, 0.5166F, 0.2636F));

		PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(12, 10).addBox(-2.0F, -4.3F, -2.0F, 4.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, 0.068F, -0.0928F, 0.2188F));

		PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.7395F, -0.5F, -3.2615F, 6.0F, 1.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.0F, 1.0F, 0.0677F, -0.0057F, 0.2247F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}