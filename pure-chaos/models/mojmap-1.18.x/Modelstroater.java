// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Modelstroater<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "stroater"), "main");
	private final ModelPart frame;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart bb_main;

	public Modelstroater(ModelPart root) {
		this.frame = root.getChild("frame");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition frame = partdefinition.addOrReplaceChild("frame", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = frame.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 36)
						.addBox(-12.0F, -17.0F, 12.0F, 29.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 30)
						.addBox(-12.0F, -17.0F, -14.0F, 29.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -1.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = frame.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 42)
						.addBox(-12.0F, -17.0F, 12.0F, 24.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 42)
						.addBox(-12.0F, -17.0F, 12.0F, 24.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 30)
						.addBox(-12.0F, -17.0F, -19.0F, 24.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -1.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(12, 12)
				.addBox(-6.0F, -12.0F, 0.5F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, -1.5F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 0)
				.addBox(2.0F, -12.0F, 0.5F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, -1.5F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-13.0F, -13.0F, -13.5F, 25.0F, 1.0F, 29.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}