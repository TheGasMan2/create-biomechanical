package net.thegasman.createbiomechanical.registry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.thegasman.createbiomechanical.CreateBiomechanical;
import net.thegasman.createbiomechanical.block.powercore.PowerCoreBlockEntity;
import net.thegasman.createbiomechanical.block.powercore.PowerCoreRenderer;
import net.thegasman.createbiomechanical.block.station.StationBlockEntity;
import net.thegasman.createbiomechanical.block.station.StationBlockEntityRenderer;

import static net.thegasman.createbiomechanical.CreateBiomechanical.REGISTRATE;

public class CBMBlockEntityTypes {

    public static final BlockEntityEntry<PowerCoreBlockEntity> POWER_CORE_ENTITY = REGISTRATE
            .blockEntity("power_core_entity", PowerCoreBlockEntity::new)
            .validBlocks(CBMBlocks.POWER_CORE)
            .renderer(() -> PowerCoreRenderer::new)
            .register();

    public static final BlockEntityEntry<StationBlockEntity> STATION_ENTITY = REGISTRATE
            .blockEntity("station_entity", StationBlockEntity::new)
            .validBlocks(CBMBlocks.STATION)
            .renderer(() -> StationBlockEntityRenderer::new)
            .register();

    public static void register() {
        CreateBiomechanical.LOGGER.info("Registering Block Entity Types");
    }
}
