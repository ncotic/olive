package com.abwfl.olive.entity.client;

import com.abwfl.olive.Olive;
import com.abwfl.olive.entity.custom.OliveEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;

public class OliveRenderer extends LivingEntityRenderer<OliveEntity, OliveRenderState, OliveModel> {
    public OliveRenderer(EntityRendererProvider.Context context) {
        super(context, new OliveModel(context.bakeLayer(OliveModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(OliveRenderState entity) {
        return ResourceLocation.fromNamespaceAndPath(Olive.MOD_ID, "textures/entity/olive.png");
    }

    @Override
    public void render(OliveRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(1f, 1f, 1f);
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    protected boolean shouldShowName(OliveEntity entity, double render) {
        return false;
    }

    @Override
    public OliveRenderState createRenderState() {
        return new OliveRenderState();
    }
}
