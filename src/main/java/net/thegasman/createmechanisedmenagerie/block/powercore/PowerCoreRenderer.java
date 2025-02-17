package net.thegasman.createmechanisedmenagerie.block.powercore;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PowerCoreRenderer extends GeoBlockRenderer<PowerCoreEntity> {
    public PowerCoreRenderer(BlockEntityRendererProvider.Context context) {
        super(new PowerCoreModel());
    }
}