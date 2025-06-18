package com.abwfl.olive.entity.client;

import com.abwfl.olive.Olive;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class OliveModel extends EntityModel<OliveRenderState> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Olive.MOD_ID, "olive"), "main");

    public OliveModel(ModelPart root) {
		super(root);
        ModelPart bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(2, 2).addBox(-1.375F, -32.825F, -0.95F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(4, 3).addBox(-0.9F, -28.125F, -0.175F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(2, 2).addBox(-1.375F, -32.825F, -0.95F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(47, 13).addBox(-1.025F, -31.35F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(49, 13).addBox(0.275F, -31.35F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(1, 4).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -39.35F, -10.75F, -1.8005F, 0.4393F, 2.9611F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(1, 4).addBox(-3.7444F, -8.8112F, -1.6208F, 8.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7F, -37.825F, -9.45F, -1.7953F, -0.3261F, 2.8363F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(1, 4).addBox(-11.8212F, -0.5757F, 0.7552F, 8.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.875F, -37.375F, 5.925F, -1.7009F, -1.1407F, 2.7545F));

		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(1, 4).addBox(-9.9185F, -6.8886F, -0.9319F, 8.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, -37.125F, 6.95F, 1.2787F, -1.1583F, -0.2832F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(1, 4).addBox(-3.7444F, -8.8112F, -1.6208F, 8.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7F, -37.125F, 6.775F, 1.2163F, -0.4568F, -0.2511F));

		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(1, 4).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, -37.775F, 8.85F, 1.1599F, 0.3731F, -0.1334F));

		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(1, 4).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.85F, -39.2F, 3.05F, 0.9797F, 1.1962F, -0.4169F));

		PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(1, 4).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.85F, -39.85F, -4.925F, -1.6735F, 1.2208F, -3.0652F));

		PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(7, 18).addBox(-0.4187F, 0.3505F, -2.7562F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4F, -37.1F, -8.05F, 0.0015F, 0.3982F, -0.2548F));

		PartDefinition cube_r10 = bb_main.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(7, 18).addBox(-0.4187F, 0.3505F, -2.7562F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.175F, -37.625F, 1.9F, -0.1731F, 0.3982F, -0.2548F));

		PartDefinition cube_r11 = bb_main.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(7, 18).addBox(-0.4187F, 0.3505F, -2.7562F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, -38.25F, -2.175F, -3.0279F, 1.164F, 3.1051F));

		PartDefinition cube_r12 = bb_main.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(7, 18).addBox(-0.4187F, 0.3505F, -2.7562F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.225F, -35.525F, 2.15F, -2.897F, 1.164F, 3.1051F));

		PartDefinition cube_r13 = bb_main.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(7, 18).addBox(-0.4187F, 0.3505F, -2.7562F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3F, -32.925F, -0.85F, -1.4135F, 1.164F, 3.1051F));

		PartDefinition cube_r14 = bb_main.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 13).addBox(-0.4187F, 0.3505F, -2.7562F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, -18.225F, -1.775F, -1.4135F, 1.164F, 3.1051F));

		PartDefinition cube_r15 = bb_main.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(3, 5).addBox(-0.4187F, -4.6495F, -1.7562F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, -20.225F, -1.775F, -1.7644F, 0.7793F, -3.1205F));

		PartDefinition cube_r16 = bb_main.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(3, 5).addBox(-1.0F, -10.0F, -4.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.55F, -16.625F, -2.25F, -2.9137F, -0.4359F, -2.9997F));

		PartDefinition cube_r17 = bb_main.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(3, 5).addBox(-1.0F, -10.0F, -4.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.975F, -16.0F, -3.35F, -3.0942F, -0.4347F, 3.091F));

		PartDefinition cube_r18 = bb_main.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(1, 1).addBox(-1.0F, -12.0F, -2.0F, 2.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.075F, -4.0F, 2.325F, 2.9898F, 1.1865F, 2.978F));

		PartDefinition cube_r19 = bb_main.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(2, 2).addBox(-1.0F, -3.0F, -2.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.975F, -25.425F, 0.125F, -1.7172F, 1.2208F, -3.0652F));

		PartDefinition cube_r20 = bb_main.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(3, 6).addBox(-1.0F, -3.0F, -2.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.85F, -25.55F, 0.725F, 1.2808F, -1.2208F, 0.0764F));

		PartDefinition cube_r21 = bb_main.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(3, 5).addBox(-1.0F, -10.0F, -3.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, -16.0F, -1.275F, -3.1144F, -0.4363F, 3.1391F));

		PartDefinition cube_r22 = bb_main.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(2, 2).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.15F, -20.025F, -0.95F, 0.0591F, -1.2208F, 0.0764F));

		PartDefinition cube_r23 = bb_main.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -10.0F, -2.0F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -16.0F, -0.925F, -0.0718F, -1.2208F, 0.0764F));

		PartDefinition cube_r24 = bb_main.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(1, 1).addBox(-1.0F, -10.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.375F, -16.0F, 1.0F, -0.026F, 0.3316F, 0.0005F));

		PartDefinition cube_r25 = bb_main.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(2, 2).addBox(-1.0F, -10.0F, -2.0F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -16.0F, -0.25F, -0.1154F, -1.2208F, 0.0764F));

		PartDefinition cube_r26 = bb_main.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(1, 1).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, -4.0F, 1.175F, 3.1158F, -0.0443F, 3.0874F));

		PartDefinition cube_r27 = bb_main.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(1, 1).addBox(-1.0F, -12.0F, -3.0F, 2.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.65F, -4.0F, -1.95F, -0.496F, -1.4069F, 0.5017F));

		PartDefinition cube_r28 = bb_main.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(2, 2).addBox(-1.0F, -12.0F, -2.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, -4.0F, -0.875F, -0.1428F, -1.218F, 0.152F));

		PartDefinition cube_r29 = bb_main.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(1, 1).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.275F, -4.0F, 0.95F, 0.05F, 0.448F, 0.063F));

		PartDefinition cube_r30 = bb_main.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(3, 3).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -1.0F, 0.7F, 0.0F, 0.5702F, 0.0F));

		PartDefinition cube_r31 = bb_main.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(3, 3).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.85F, -1.0F, -0.9F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r32 = bb_main.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, -1.0F, -4.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.0F, 2.0F, 0.0F, 0.6545F, 0.0F));

		PartDefinition cube_r33 = bb_main.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(6, 11).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 0.0F, 0.0F, 0.0F, -0.1309F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(@NotNull OliveRenderState state) {

	}
}