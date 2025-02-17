package net.thegasman.createmechanisedmenagerie.entity.cogolem;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CogolemModel extends GeoModel<CogolemEntity> {
    @Override
    public ResourceLocation getModelResource(CogolemEntity animatable) {
        return new ResourceLocation(CreateMechanisedMenagerie.MODID, "geo/cogolem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CogolemEntity animatable) {
        return new ResourceLocation(CreateMechanisedMenagerie.MODID, "textures/entity/cogolem.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CogolemEntity animatable) {
        return new ResourceLocation(CreateMechanisedMenagerie.MODID, "animations/cogolem.animation.json");
    }

    @Override
    public void setCustomAnimations(CogolemEntity animatable, long instanceId, AnimationState<CogolemEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
