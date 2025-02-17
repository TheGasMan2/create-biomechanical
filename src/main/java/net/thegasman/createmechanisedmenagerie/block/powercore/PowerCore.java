package net.thegasman.createmechanisedmenagerie.block.powercore;

import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.thegasman.createmechanisedmenagerie.registry.CMMBlockEntityTypes;

public class PowerCore extends Block implements IBE<PowerCoreEntity> {

    public PowerCore(Properties pProperties) {
        super(pProperties);
    }



    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public Class<PowerCoreEntity> getBlockEntityClass() {
        return PowerCoreEntity.class;
    }

    @Override
    public BlockEntityType<? extends PowerCoreEntity> getBlockEntityType() {
       return CMMBlockEntityTypes.POWER_CORE_ENTITY.get();
    }
}
