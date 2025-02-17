package net.thegasman.createmechanisedmenagerie.item;

import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.thegasman.createmechanisedmenagerie.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMechanisedMenagerie.MODID);

    public static final RegistryObject<CreativeModeTab> CREATE_MECHANISED_MENAGERIE_TAB = CREATIVE_MODE_TABS.register("create_mechanised_menagerie_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.POWER_CORE_ITEM.get()))
                    .title(Component.translatable("creativetab.create_mechanised_menagerie_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ELECTRON_BATTERY.get());
                        pOutput.accept(ModItems.INCOMPLETE_ELECTRON_BATTERY.get());
                        pOutput.accept(ModItems.POWER_CORE_ITEM.get());
                        pOutput.accept(ModItems.COGOLEM_SPAWN_EGG.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

