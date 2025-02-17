package net.thegasman.createmechanisedmenagerie.block.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.thegasman.createmechanisedmenagerie.block.entity.custom.PowerCoreEntity;
import software.bernie.geckolib.model.GeoModel;

public class PowerCoreModel extends GeoModel<PowerCoreEntity> {
    @Override
    public ResourceLocation getModelResource(PowerCoreEntity powerCoreEntity) {
        return new ResourceLocation(CreateMechanisedMenagerie.MODID, "geo/power_core.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PowerCoreEntity powerCoreEntity) {
        return new ResourceLocation(CreateMechanisedMenagerie.MODID, "textures/block/power_core.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PowerCoreEntity powerCoreEntity) {
        return new ResourceLocation(CreateMechanisedMenagerie.MODID, "animations/power_core.animation.json");
    }
}
