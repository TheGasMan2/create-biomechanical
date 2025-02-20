package net.thegasman.createbiomechanical.block.powercore.item;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PowerCoreItemRenderer extends GeoItemRenderer<PowerCoreItem> {
    public PowerCoreItemRenderer() {
        super(new PowerCoreItemModel());
    }
}
