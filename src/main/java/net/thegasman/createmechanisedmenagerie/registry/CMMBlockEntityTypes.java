package net.thegasman.createmechanisedmenagerie.registry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie;
import net.thegasman.createmechanisedmenagerie.block.powercore.PowerCoreEntity;
import net.thegasman.createmechanisedmenagerie.block.powercore.PowerCoreRenderer;
import net.thegasman.createmechanisedmenagerie.block.station.Station;
import net.thegasman.createmechanisedmenagerie.block.station.StationEntity;
import net.thegasman.createmechanisedmenagerie.block.station.StationRenderer;

import static net.thegasman.createmechanisedmenagerie.CreateMechanisedMenagerie.REGISTRATE;

public class CMMBlockEntityTypes {

    public static final BlockEntityEntry<PowerCoreEntity> POWER_CORE_ENTITY = REGISTRATE
            .blockEntity("power_core_entity", PowerCoreEntity::new)
            .validBlocks(CMMBlocks.POWER_CORE)
            .renderer(() -> PowerCoreRenderer::new)
            .register();

    public static final BlockEntityEntry<StationEntity> STATION_ENTITY = REGISTRATE
            .blockEntity("station_entity", StationEntity::new)
            .validBlocks(CMMBlocks.STATION)
            .renderer(() -> StationRenderer::new)
            .register();

    public static void register() {
        CreateMechanisedMenagerie.LOGGER.info("Registering Block Entity Types");
    }
}
