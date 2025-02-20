package net.thegasman.createbiomechanical.entity.cogolem;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CogolemRenderer extends GeoEntityRenderer<CogolemEntity> {
    public CogolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CogolemModel());
    }

    @Override
    public void render(CogolemEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}

