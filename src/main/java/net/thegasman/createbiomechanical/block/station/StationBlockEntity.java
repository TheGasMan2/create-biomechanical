package net.thegasman.createbiomechanical.block.station;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

public class StationBlockEntity extends KineticBlockEntity {

    BlockPos controllerPos = BlockPos.ZERO;

    public StationBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }

    @Override
    public void tick() {
        super.tick();
        if (!isController())
            return;

    }

    public int getLeftShaftSpeed() {
        return 0;
    }

    public int getRightShaftSpeed() {
        return 0;
    }

    public void setControllerPos(@Nonnull BlockPos pos) {
        controllerPos = pos;
    }


    public boolean isController() {
        return getBlockState().getValue(StationBlock.SHAPE) == StationShape.CENTER;
    }

    public Optional<StationBlockEntity> getController() {
        if (isController()) {
            return Optional.of(this);
        }
        if (controllerPos == null || !(level.getBlockEntity(controllerPos) instanceof StationBlockEntity stationBlockEntity)) {
            return Optional.empty();
        }
        return Optional.of(stationBlockEntity);
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        return super.addToGoggleTooltip(tooltip, isPlayerSneaking);
    }

    @Override
    protected void read(CompoundTag compound, boolean clientPacket) {
        super.read(compound, clientPacket);
        controllerPos = BlockPos.of(compound.getLong("controllerPos"));
    }

    @Override
    protected void write(CompoundTag compound, boolean clientPacket) {
        super.write(compound, clientPacket);
        compound.putLong("controllerPos", controllerPos.asLong());
    }

    public void removeMultiBlock() {
        getController().ifPresent(controller -> {
            level.setBlockAndUpdate(controllerPos, Blocks.AIR.defaultBlockState());
        });
    }
}

