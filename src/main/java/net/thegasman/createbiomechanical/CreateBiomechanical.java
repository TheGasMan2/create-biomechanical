package net.thegasman.createbiomechanical;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thegasman.createbiomechanical.registry.*;
import org.slf4j.Logger;

@Mod(CreateBiomechanical.MODID)
public class CreateBiomechanical {

    public static final String MODID = "createbiomechanical";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateBiomechanical.MODID);


    public CreateBiomechanical(FMLJavaModLoadingContext context) {
        LOGGER.info("Initializing Create: Biomechanical");
        IEventBus modEventBus = context.getModEventBus();
        CBMItems.register();
        CBMBlocks.register();
        CBMBlockEntityTypes.register();
        CBMEntityTypes.register();
        CBMCreativeModTabs.register(modEventBus);

        REGISTRATE.registerEventListeners(modEventBus);
    }
}
