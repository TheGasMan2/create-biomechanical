package net.thegasman.createmechanisedmenagerie.item;

import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thegasman.createmechanisedmenagerie.block.ModBlocks;
import net.thegasman.createmechanisedmenagerie.entity.ModEntities;
import net.thegasman.createmechanisedmenagerie.item.custom.PowerCoreItem;

import static net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> ELECTRON_BATTERY = ITEMS.register("electron_battery",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INCOMPLETE_ELECTRON_BATTERY = ITEMS.register("incomplete_electron_battery",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COGOLEM_SPAWN_EGG = ITEMS.register("cogolem_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.COGOLEM, 0x7e7f73, 0xba8459, new Item.Properties()));

    public static final RegistryObject<Item> POWER_CORE_ITEM = ITEMS.register("power_core",
            () -> new PowerCoreItem(ModBlocks.POWER_CORE.get(), new Item.Properties()));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);;
    }
}