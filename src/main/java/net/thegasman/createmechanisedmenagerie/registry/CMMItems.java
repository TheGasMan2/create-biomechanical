package net.thegasman.createmechanisedmenagerie.registry;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;

import static net.minecraftforge.registries.ForgeRegistries.Keys.ITEMS;
import static net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie.REGISTRATE;

public class CMMItems {

    public static final ItemEntry<Item> ELECTRON_BATTERY = REGISTRATE
            .item("electron_battery", Item::new)
            .register();


    public static final ItemEntry<Item> INCOMPLETE_ELECTRON_BATTERY = REGISTRATE
            .item("incomplete_electron_battery", Item::new)
            .register();

    public static void register() {
        CreateMechanisedMenagerie.LOGGER.info("Registering Items");
    }
}
