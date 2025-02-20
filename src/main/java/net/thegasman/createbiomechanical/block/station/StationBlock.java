package net.thegasman.createbiomechanical.block.station;

import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.utility.Lang;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thegasman.createbiomechanical.registry.CBMBlockEntityTypes;
import org.jetbrains.annotations.NotNull;

public class StationBlock extends HorizontalKineticBlock implements IBE<StationBlockEntity> {


    public static final EnumProperty<Shape> SHAPE = EnumProperty.create("shape", Shape.class);

    public enum Shape implements StringRepresentable {
        CENTER, LEFTSHAFT, RIGHTSHAFT, EMPTY;

        @Override
        public @NotNull String getSerializedName() {
            return Lang.asId(name());
        }
    }

    public StationBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return null;
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return super.hasShaftTowards(world, pos, state, face);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE);
        super.createBlockStateDefinition(builder);
    }

    private static final VoxelShape CENTER_SHAPE = Block.box(0, 0, 0, 4, 16, 16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.getValue(SHAPE) == Shape.EMPTY) {
            return Shapes.empty();
        }
        return CENTER_SHAPE;
    }


    @Override
    public Class<StationBlockEntity> getBlockEntityClass() {
        return StationBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends StationBlockEntity> getBlockEntityType() {
        return CBMBlockEntityTypes.STATION_ENTITY.get();
    }
}
