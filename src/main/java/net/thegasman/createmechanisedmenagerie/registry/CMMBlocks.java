package net.thegasman.createmechanisedmenagerie.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.thegasman.createmechanisedmenagerie.block.powercore.PowerCore;
import net.thegasman.createmechanisedmenagerie.block.powercore.item.PowerCoreItem;

import static net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie.REGISTRATE;

public class CMMBlocks {

    public static final BlockEntry<PowerCore> POWER_CORE = REGISTRATE
            .block("power_core", PowerCore::new)
            .initialProperties(()->Blocks.IRON_BLOCK)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .blockstate(NonNullBiConsumer.noop())
            .item(PowerCoreItem::new)
            .build()
            .register();

    public static void register() {
        CreateMechanisedMenagerie.LOGGER.info("Registering Blocks");
    }
}
