package net.thegasman.createbiomechanical.registry;

import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.thegasman.createbiomechanical.CreateBiomechanical;
import net.thegasman.createbiomechanical.block.powercore.PowerCoreBlock;
import net.thegasman.createbiomechanical.block.powercore.item.PowerCoreItem;
import net.thegasman.createbiomechanical.block.station.StationBlock;
import net.thegasman.createbiomechanical.block.station.StationBlockItem;

import static net.thegasman.createbiomechanical.CreateBiomechanical.REGISTRATE;

public class CBMBlocks {

    public static final BlockEntry<PowerCoreBlock> POWER_CORE = REGISTRATE
            .block("power_core", PowerCoreBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .blockstate(NonNullBiConsumer.noop())
            .item(PowerCoreItem::new)
            .build()
            .register();

    // Block strength
    public static final BlockEntry<StationBlock> STATION = REGISTRATE
            .block("station", StationBlock::new)
            .transform(BlockStressDefaults.setImpact(8.0))
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .addLayer(() -> RenderType::cutoutMipped)
            .blockstate((c, p) -> p.horizontalBlock(c.getEntry(), AssetLookup.standardModel(c, p)))
            .item(StationBlockItem::new)
            .build()
            .register();

    public static void register() {
        CreateBiomechanical.LOGGER.info("Registering Blocks");
    }

    @OnlyIn(Dist.CLIENT)
    public static void clientSetup(final FMLClientSetupEvent event) {
        // Register the block to use a translucent render layer
        ItemBlockRenderTypes.setRenderLayer(CBMBlocks.STATION.get(), RenderType.translucent());
    }
}
