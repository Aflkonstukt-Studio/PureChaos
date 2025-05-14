// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
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

public class Modelbaldi<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "baldi"), "main");
	private final ModelPart head;
	private final ModelPart bb_main;

	public Modelbaldi(ModelPart root) {
		this.head = root.getChild("head");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(36, 24)
						.addBox(-5.0F, -49.0F, 0.0F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(24, 34)
						.addBox(-5.0F, -67.0F, 0.0F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(32, 3)
						.addBox(-7.0F, -52.0F, 0.0F, 14.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(32, 0)
						.addBox(-7.0F, -64.0F, 0.0F, 14.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 31)
						.addBox(-9.0F, -55.0F, 0.0F, 18.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 28)
						.addBox(-9.0F, -58.0F, 0.0F, 18.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 25)
						.addBox(-9.0F, -61.0F, 0.0F, 18.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(12, 34)
						.addBox(-5.0F, -21.0F, 0.0F, 3.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(6, 34)
						.addBox(2.0F, -21.0F, 0.0F, 3.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-8.0F, -46.0F, 0.0F, 16.0F, 25.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(36, 24)
						.addBox(-5.0F, -49.0F, 0.0F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition ruler_r1 = bb_main.addOrReplaceChild("ruler_r1",
				CubeListBuilder.create().texOffs(18, 34).addBox(-5.2216F, -40.7708F, -1.0F, 3.0F, 18.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition rightarm_r1 = bb_main.addOrReplaceChild("rightarm_r1",
				CubeListBuilder.create().texOffs(32, 6).addBox(12.0851F, -43.4415F, -0.9F, 3.0F, 18.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition leftarm_r1 = bb_main.addOrReplaceChild("leftarm_r1",
				CubeListBuilder.create().texOffs(0, 34).addBox(9.0608F, -42.6946F, 0.0F, 3.0F, 21.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}