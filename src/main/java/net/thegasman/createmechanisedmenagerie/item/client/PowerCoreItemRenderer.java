package net.thegasman.createmechanisedmenagerie.item.client;

import net.thegasman.createmechanisedmenagerie.item.custom.PowerCoreItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PowerCoreItemRenderer extends GeoItemRenderer<PowerCoreItem> {
    public PowerCoreItemRenderer() {
        super(new PowerCoreItemModel());
    }
}
