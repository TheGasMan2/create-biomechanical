package net.thegasman.createbiomechanical.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.thegasman.createbiomechanical.CreateBiomechanical;

import static net.thegasman.createbiomechanical.CreateBiomechanical.REGISTRATE;

public class CBMCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateBiomechanical.MODID);

    public static final RegistryObject<CreativeModeTab> CREATE_MECHANISED_MENAGERIE_TAB = CREATIVE_MODE_TABS.register("create_biomechanical_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CBMBlocks.POWER_CORE))
                    .title(Component.translatable(CreateBiomechanical.MODID + ".creativetab.create_biomechanical_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(CBMItems.ELECTRON_BATTERY);
                        pOutput.accept(CBMItems.INCOMPLETE_ELECTRON_BATTERY);
                        pOutput.accept(CBMItems.STURDY_CIRCUIT);
                        pOutput.accept(CBMBlocks.POWER_CORE);
                        pOutput.accept(CBMBlocks.STATION);
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        REGISTRATE.addRawLang(CreateBiomechanical.MODID + ".creativetab.create_biomechanical_tab", "Create: Biomechanical");
    }
}

