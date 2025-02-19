package net.thegasman.createmechanisedmenagerie.block.station;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.thegasman.createmechanisedmenagerie.registry.CMMBlockEntityTypes;

public class StationRenderer implements BlockEntityRenderer<StationEntity> {

    public StationRenderer(BlockEntityRendererProvider.Context context) {}

    public static void clientSetup(final FMLClientSetupEvent event) {
        // Register the Block Entity renderer
        BlockEntityRenderers.register(CMMBlockEntityTypes.STATION_ENTITY.get(), StationRenderer::new);
    }

    @Override
    public void render(StationEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState state = blockEntity.getBlockState();

        // Load the baked model
        BakedModel model = Minecraft.getInstance().getModelManager().getModel(
                new ResourceLocation(CreateMechanisedMenagerie.MODID, "block/station")
        );

        if (model == null) return;

        poseStack.pushPose();

        // Apply rotation based on block facing
        float angle = switch (state.getValue(Station.FACING)) {
            case NORTH -> 180f;
            case EAST -> 90f;
            case SOUTH -> 0f;
            case WEST -> 270f;
            default -> 0f;
        };

        poseStack.translate(0.5, 0, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(angle));
        poseStack.translate(-0.5, 0, -0.5);

        // Use RenderType.translucent() for transparent block rendering
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.translucent());  // Render with transparency

        // Render the model
        Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
                poseStack.last(), vertexConsumer, state, model, 1.0F, 1.0F, 1.0F, packedLight, packedOverlay
        );

        poseStack.popPose();
    }
}

