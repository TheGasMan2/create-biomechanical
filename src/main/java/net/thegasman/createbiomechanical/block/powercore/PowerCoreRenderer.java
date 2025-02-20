package net.thegasman.createbiomechanical.block.powercore;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PowerCoreRenderer extends GeoBlockRenderer<PowerCoreBlockEntity> {
    public PowerCoreRenderer(BlockEntityRendererProvider.Context context) {
        super(new PowerCoreModel());
    }
}