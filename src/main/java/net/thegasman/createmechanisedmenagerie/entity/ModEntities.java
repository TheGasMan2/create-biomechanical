package net.thegasman.createmechanisedmenagerie.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.thegasman.createmechanisedmenagerie.entity.custom.CogolemEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CreateMechanisedMenagerie.MODID);

    public static final RegistryObject<EntityType<CogolemEntity>> COGOLEM =
            ENTITY_TYPES.register("cogolem",
                    () -> EntityType.Builder.of(CogolemEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(CreateMechanisedMenagerie.MODID, "cogolem").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
