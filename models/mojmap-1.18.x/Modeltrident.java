// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeltrident<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "trident"), "main");
	private final ModelPart base;
	private final ModelPart bb_main;

	public Modeltrident(ModelPart root) {
		this.base = root.getChild("base");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-5.0F, -38.0F, -13.0F, 9.0F, 2.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(0, 29)
						.addBox(-4.0F, -36.0F, -3.0F, 7.0F, 36.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(53, 49)
						.addBox(-5.0F, -58.0F, -13.0F, 9.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(45, 0)
						.addBox(-5.0F, -58.0F, 7.0F, 9.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(28, 29)
						.addBox(-5.0F, -58.0F, -3.0F, 9.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}