package com.Killer.killersblocksnstuff;


import com.Killer.killersblocksnstuff.core.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("killersblocksnstuff")
@EventBusSubscriber
public class KillersBlocksNStuff {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "kbns";
    public static final ItemGroup KBNS_TAB = new KbnsItemGroup("kbns_tab");

    public KillersBlocksNStuff() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        SurfaceBuilderInit.SURFACE_BUILDERS.register(bus);
        BiomeInit.BIOMES.register(bus);
        BiomeInit.registerBiomes();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event) {

        FeatureInit.registerOres();

    }

    private void doClientStuff(FMLClientSetupEvent event) {
    }
}
