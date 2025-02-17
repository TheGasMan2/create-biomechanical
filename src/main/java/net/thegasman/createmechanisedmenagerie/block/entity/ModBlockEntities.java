package net.thegasman.createmechanisedmenagerie.block.entity;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thegasman.createmechanisedmenagerie.block.ModBlocks;
import net.thegasman.createmechanisedmenagerie.block.entity.custom.PowerCoreEntity;

import static net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie.MODID;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    public static final RegistryObject<BlockEntityType<PowerCoreEntity>> POWER_CORE_ENTITY =
            BLOCK_ENTITIES.register("power_core_entity",
                    () -> BlockEntityType.Builder.of(PowerCoreEntity::new,
                            ModBlocks.POWER_CORE.get()).build(null));

    public static void register(IEventBus modEventBus) {
        BLOCK_ENTITIES.register(modEventBus);
    }
}