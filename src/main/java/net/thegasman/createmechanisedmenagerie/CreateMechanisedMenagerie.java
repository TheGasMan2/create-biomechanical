package net.thegasman.createmechanisedmenagerie;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thegasman.createmechanisedmenagerie.registry.ModCreativeModTabs;
import net.thegasman.createmechanisedmenagerie.registry.CMMBlockEntityTypes;
import net.thegasman.createmechanisedmenagerie.registry.CMMBlocks;
import net.thegasman.createmechanisedmenagerie.registry.CMMEntityTypes;
import net.thegasman.createmechanisedmenagerie.registry.CMMItems;
import org.slf4j.Logger;

@Mod(CreateMechanisedMenagerie.MODID)
public class CreateMechanisedMenagerie {

    public static final String MODID = "createmechanisedmenagerie";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateMechanisedMenagerie.MODID);


    public CreateMechanisedMenagerie(FMLJavaModLoadingContext context) {
        LOGGER.info("Initializing Create Mechanised Menagerie");
        IEventBus modEventBus = context.getModEventBus();
        CMMItems.register();
        CMMBlocks.register();
        CMMBlockEntityTypes.register();
        CMMEntityTypes.register();
        ModCreativeModTabs.register(modEventBus);

        REGISTRATE.registerEventListeners(modEventBus);
    }


}
