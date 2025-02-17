package net.thegasman.createmechanisedmenagerie.event;

import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.thegasman.createmechanisedmenagerie.entity.ModEntities;
import net.thegasman.createmechanisedmenagerie.entity.custom.CogolemEntity;

@Mod.EventBusSubscriber(modid = CreateMechanisedMenagerie.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        // Register attributes for the CogolemEntity
        event.put(ModEntities.COGOLEM.get(), CogolemEntity.createAttributes().build());
    }
}
