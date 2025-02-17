package net.thegasman.createmechanisedmenagerie.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.thegasman.createmechanisedmenagerie.entity.custom.CogolemEntity;
import software.bernie.geckolib.model.GeoModel;
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

