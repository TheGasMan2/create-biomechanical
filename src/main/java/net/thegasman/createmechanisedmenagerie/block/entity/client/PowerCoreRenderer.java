package net.thegasman.createmechanisedmenagerie.block.entity.client;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.thegasman.createmechanisedmenagerie.block.entity.custom.PowerCoreEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PowerCoreRenderer extends GeoBlockRenderer<PowerCoreEntity> {
    public PowerCoreRenderer(BlockEntityRendererProvider.Context context) {
        super(new PowerCoreModel());
    }
}