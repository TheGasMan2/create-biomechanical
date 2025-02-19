package net.thegasman.createmechanisedmenagerie.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.thegasman.createmechanisedmenagerie.block.powercore.PowerCore;
import net.thegasman.createmechanisedmenagerie.block.powercore.item.PowerCoreItem;
import net.thegasman.createmechanisedmenagerie.block.station.Station;
import net.thegasman.createmechanisedmenagerie.block.station.item.StationItem;

import static net.minecraft.world.item.Items.registerBlock;
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

    public static final BlockEntry<Station> STATION = REGISTRATE
            .block("station", Station::new)
            .initialProperties(() -> Blocks.GLASS)  // Make sure GLASS is used as the base block
            .properties(props -> props
                    .strength(1.0F, 1.0F)  // Block strength
                    .noOcclusion()  // No occlusion; allows transparency
                    .lightLevel(state -> 0)  // No light emission
            )
            .item(StationItem::new)
            .build()
            .register();

    public static void register() {
        CreateMechanisedMenagerie.LOGGER.info("Registering Blocks");
    }

    @OnlyIn(Dist.CLIENT)
    public static void clientSetup(final FMLClientSetupEvent event) {
        // Register the block to use a translucent render layer
        ItemBlockRenderTypes.setRenderLayer(CMMBlocks.STATION.get(), RenderType.translucent());
    }
}
