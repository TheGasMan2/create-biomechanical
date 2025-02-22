package net.thegasman.createbiomechanical.registry;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.thegasman.createbiomechanical.CreateBiomechanical;

import static net.thegasman.createbiomechanical.CreateBiomechanical.REGISTRATE;

public class CBMItems {

    public static final ItemEntry<Item> ELECTRON_BATTERY = REGISTRATE
            .item("electron_battery", Item::new)
            .register();


    public static final ItemEntry<Item> INCOMPLETE_ELECTRON_BATTERY = REGISTRATE
            .item("incomplete_electron_battery", Item::new)
            .register();

    public static final ItemEntry<Item> STURDY_CIRCUIT = REGISTRATE
            .item("sturdy_circuit", Item::new)
            .register();

    public static void register() {
        CreateBiomechanical.LOGGER.info("Registering Items");
    }
}
