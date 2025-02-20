package net.thegasman.createbiomechanical.block.powercore.item;

import net.minecraft.resources.ResourceLocation;
import net.thegasman.createbiomechanical.CreateBiomechanical;
import software.bernie.geckolib.model.GeoModel;

public class PowerCoreItemModel extends GeoModel<PowerCoreItem> {
    @Override
    public ResourceLocation getModelResource(PowerCoreItem powerCoreItem) {
        return new ResourceLocation(CreateBiomechanical.MODID, "geo/power_core.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PowerCoreItem powerCoreItem) {
        return new ResourceLocation(CreateBiomechanical.MODID, "textures/block/power_core.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PowerCoreItem powerCoreItem) {
        return new ResourceLocation(CreateBiomechanical.MODID, "animations/power_core.animation.json");
    }
}
