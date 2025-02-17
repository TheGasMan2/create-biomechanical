package net.thegasman.createmechanisedmenagerie.registry;

import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie.REGISTRATE;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMechanisedMenagerie.MODID);

    public static final RegistryObject<CreativeModeTab> CREATE_MECHANISED_MENAGERIE_TAB = CREATIVE_MODE_TABS.register("create_mechanised_menagerie_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CMMBlocks.POWER_CORE))
                    .title(Component.translatable("creativetab.create_mechanised_menagerie_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(CMMItems.ELECTRON_BATTERY);
                        pOutput.accept(CMMItems.INCOMPLETE_ELECTRON_BATTERY);
                        pOutput.accept(CMMBlocks.POWER_CORE);
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        REGISTRATE.addRawLang("creativetab.create_mechanised_menagerie_tab", "Create Mechanised Menagerie");
    }
}

