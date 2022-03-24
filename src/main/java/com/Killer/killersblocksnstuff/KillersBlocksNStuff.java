package com.Killer.killersblocksnstuff;


import com.Killer.killersblocksnstuff.common.container.*;
import com.Killer.killersblocksnstuff.common.container.screen.*;
import com.Killer.killersblocksnstuff.common.tileEntity.*;
import com.Killer.killersblocksnstuff.core.init.*;
import com.Killer.killersblocksnstuff.data.recipes.*;
import com.Killer.killersblocksnstuff.entity.*;
import com.Killer.killersblocksnstuff.entity.render.*;
import net.minecraft.block.*;
import net.minecraft.client.gui.*;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.client.registry.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("killersblocksnstuff")
@EventBusSubscriber
public class KillersBlocksNStuff {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "killersblocksnstuff";
    public static final ItemGroup KBNS_TAB = new KbnsItemGroup("killersblocksnstuff_tab");

    public KillersBlocksNStuff() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        FeatureInit.FEATURES.register(bus);
        SurfaceBuilderInit.SURFACE_BUILDERS.register(bus);
        BiomeInit.BIOMES.register(bus);
        BiomeInit.registerBiomes();
        MinecraftForge.EVENT_BUS.register(this);
        KbnsEntityTypes.register(bus);
        KbnsContainers.register(bus);
        KbnsTileEntities.register(bus);
        KbnsRecipeTypes.register(bus);
    }

    private void setup(FMLCommonSetupEvent event) {

        FeatureInit.registerOres();

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ScreenManager.register(KbnsContainers.VIBRANIUM_FORGE_CONTAINER.get(), VibraniumForgeScreen::new);
        });

        RenderingRegistry.registerEntityRenderingHandler(KbnsEntityTypes.MINI_BOSS.get(), MiniBossRenderer::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

}
