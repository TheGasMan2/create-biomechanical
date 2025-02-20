package net.thegasman.createbiomechanical.block.station;

import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thegasman.createbiomechanical.registry.CBMBlockEntityTypes;

public class StationBlock extends HorizontalKineticBlock implements IBE<StationBlockEntity> {


    public static final EnumProperty<StationShape> SHAPE = EnumProperty.create("shape", StationShape.class);

    public StationBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(SHAPE, StationShape.BOTTOM_CENTER));
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        StationShape shape = state.getValue(SHAPE);
        if (shape == StationShape.TOP_FRONT_LEFT_SHAFT || shape == StationShape.TOP_FRONT_RIGHT_SHAFT) {
            return state.getValue(HORIZONTAL_FACING).getCounterClockWise().getAxis();
        }
        return null;
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        StationShape shape = state.getValue(SHAPE);
        Direction front = state.getValue(HORIZONTAL_FACING);
        if (shape == StationShape.TOP_FRONT_LEFT_SHAFT) {
            return face == front.getClockWise();
        }
        if (shape == StationShape.TOP_FRONT_RIGHT_SHAFT) {
            return face == front.getCounterClockWise();
        }
        return false;
    }

    @Override
    public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, worldIn, pos, oldState, isMoving);
        if (state.getValue(SHAPE) != StationShape.BOTTOM_CENTER) {
            return;
        }
        Direction front = state.getValue(HORIZONTAL_FACING);
        Direction left = state.getValue(HORIZONTAL_FACING).getClockWise();
        Direction right = state.getValue(HORIZONTAL_FACING).getCounterClockWise();
        BlockPos leftShaftPos = pos.relative(front).above().relative(left);
        BlockPos rightShaftPos = pos.relative(front).above().relative(right);
        worldIn.setBlockAndUpdate(leftShaftPos, defaultBlockState().setValue(SHAPE, StationShape.TOP_FRONT_LEFT_SHAFT).setValue(HORIZONTAL_FACING, front));
        worldIn.setBlockAndUpdate(rightShaftPos, defaultBlockState().setValue(SHAPE, StationShape.TOP_FRONT_RIGHT_SHAFT).setValue(HORIZONTAL_FACING, front));
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getValue(SHAPE) != StationShape.BOTTOM_CENTER) {
            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
            return;
        }
        Direction front = pState.getValue(HORIZONTAL_FACING);
        Direction left = pState.getValue(HORIZONTAL_FACING).getClockWise();
        Direction right = pState.getValue(HORIZONTAL_FACING).getCounterClockWise();
        BlockPos leftShaftPos = pPos.relative(front).above().relative(left);
        BlockPos rightShaftPos = pPos.relative(front).above().relative(right);
        pLevel.destroyBlock(leftShaftPos, false);
        pLevel.destroyBlock(rightShaftPos, false);
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(SHAPE).getShape(pState.getValue(HORIZONTAL_FACING));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public Class<StationBlockEntity> getBlockEntityClass() {
        return StationBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends StationBlockEntity> getBlockEntityType() {
        return CBMBlockEntityTypes.STATION_ENTITY.get();
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        if (pState.getValue(SHAPE) == StationShape.BOTTOM_CENTER) {
            return RenderShape.MODEL;
        }
        return RenderShape.INVISIBLE;
    }
}
