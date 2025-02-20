package net.thegasman.createbiomechanical.block.powercore;

import net.minecraft.resources.ResourceLocation;
import net.thegasman.createbiomechanical.CreateBiomechanical;
import software.bernie.geckolib.model.GeoModel;

public class PowerCoreModel extends GeoModel<PowerCoreBlockEntity> {
    @Override
    public ResourceLocation getModelResource(PowerCoreBlockEntity powerCoreEntity) {
        return new ResourceLocation(CreateBiomechanical.MODID, "geo/power_core.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PowerCoreBlockEntity powerCoreEntity) {
        return new ResourceLocation(CreateBiomechanical.MODID, "textures/block/power_core.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PowerCoreBlockEntity powerCoreEntity) {
        return new ResourceLocation(CreateBiomechanical.MODID, "animations/power_core.animation.json");
    }
}
