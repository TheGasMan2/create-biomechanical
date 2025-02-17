package net.thegasman.createmechanisedmenagerie;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thegasman.createmechanisedmenagerie.block.ModBlocks;
import net.thegasman.createmechanisedmenagerie.block.entity.ModBlockEntities;
import net.thegasman.createmechanisedmenagerie.block.entity.client.PowerCoreRenderer;
import net.thegasman.createmechanisedmenagerie.entity.ModEntities;
import net.thegasman.createmechanisedmenagerie.entity.client.CogolemRenderer;
import net.thegasman.createmechanisedmenagerie.entity.custom.CogolemEntity;
import net.thegasman.createmechanisedmenagerie.item.ModCreativeModTabs;
import net.thegasman.createmechanisedmenagerie.item.ModItems;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateMechanisedMenagerie.MODID)
public class CreateMechanisedMenagerie
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "createmechanisedmenagerie";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateMechanisedMenagerie.MODID);

    private void setup(final FMLCommonSetupEvent event) {
        // Other setup code
    }

    public CreateMechanisedMenagerie(FMLJavaModLoadingContext context) {

        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModEntities.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = CreateMechanisedMenagerie.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(RegisterClientReloadListenersEvent event) {
            // Register BlockEntityRenderer for PowerCoreEntity
            BlockEntityRenderers.register(ModBlockEntities.POWER_CORE_ENTITY.get(), PowerCoreRenderer::new);
        }
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Register the entity renderer
            EntityRenderers.register(ModEntities.COGOLEM.get(), CogolemRenderer::new);
        }
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
}
