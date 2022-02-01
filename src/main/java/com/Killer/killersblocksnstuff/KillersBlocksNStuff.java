package com.Killer.killersblocksnstuff;


import com.Killer.killersblocksnstuff.core.init.*;
import com.Killer.killersblocksnstuff.entity.*;
import com.Killer.killersblocksnstuff.entity.render.*;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.*;
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
    }

    private void setup(FMLCommonSetupEvent event) {

        FeatureInit.registerOres();

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
        });
        RenderingRegistry.registerEntityRenderingHandler(KbnsEntityTypes.MINI_BOSS.get(), MiniBossRenderer::new);
    }
}
