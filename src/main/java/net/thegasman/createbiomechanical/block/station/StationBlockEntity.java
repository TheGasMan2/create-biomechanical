package net.thegasman.createbiomechanical.block.station;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class StationBlockEntity extends KineticBlockEntity {


    public StationBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }

    @Override
    public void tick() {
        super.tick();
    }

    public boolean isController() {
        return getBlockState().getValue(StationBlock.SHAPE) == StationShape.BOTTOM_CENTER;
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        return super.addToGoggleTooltip(tooltip, isPlayerSneaking);
    }

    @Nullable
    public StationBlockEntity getController() {
        if (isController())
            return this;
        return null;
    }
}

