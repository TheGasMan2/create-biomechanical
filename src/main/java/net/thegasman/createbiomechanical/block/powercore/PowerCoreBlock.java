package net.thegasman.createbiomechanical.block.powercore;

import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.thegasman.createbiomechanical.registry.CBMBlockEntityTypes;

public class PowerCoreBlock extends Block implements IBE<PowerCoreBlockEntity> {

    public PowerCoreBlock(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public Class<PowerCoreBlockEntity> getBlockEntityClass() {
        return PowerCoreBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends PowerCoreBlockEntity> getBlockEntityType() {
        return CBMBlockEntityTypes.POWER_CORE_ENTITY.get();
    }
}
