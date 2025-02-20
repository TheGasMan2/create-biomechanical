package net.thegasman.createbiomechanical.block.station;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class StationBlockItem extends BlockItem {

    public StationBlockItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }


    //todo add check for multi block structure, ensure all positions are valid
    @Override
    protected boolean canPlace(BlockPlaceContext pContext, BlockState pState) {
        return super.canPlace(pContext, pState);
    }

}
