package net.thegasman.createbiomechanical.block.station;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public class StationBlockEntityRenderer extends ShaftRenderer<StationBlockEntity> {

    public StationBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void renderSafe(StationBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        BlockState state = be.getBlockState();
        StationShape shape = state.getValue(StationBlock.SHAPE);
        if (shape != StationShape.TOP_FRONT_LEFT_SHAFT && shape != StationShape.TOP_FRONT_RIGHT_SHAFT)
            return;

        Direction facing = state.getValue(StationBlock.HORIZONTAL_FACING);
        Direction shaftFacing = shape == StationShape.TOP_FRONT_LEFT_SHAFT ? facing.getClockWise() : facing.getCounterClockWise();
        RenderType type = getRenderType(be, state);
        if (type != null)
            renderRotatingBuffer(be, getRotatedModel(be, state, shaftFacing), ms, buffer.getBuffer(type), light);
    }

    protected SuperByteBuffer getRotatedModel(StationBlockEntity be, BlockState state, Direction direction) {
        return CachedBufferer.partialFacing(AllPartialModels.SHAFT_HALF, state, direction);
    }
}
