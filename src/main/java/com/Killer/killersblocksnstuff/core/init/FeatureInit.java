package com.Killer.killersblocksnstuff.core.init;

import com.Killer.killersblocksnstuff.*;
import com.Killer.killersblocksnstuff.common.world.feature.*;
import net.minecraft.block.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.*;
import net.minecraftforge.common.world.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.registries.*;

import java.util.*;


@Mod.EventBusSubscriber
public class FeatureInit {


    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, KillersBlocksNStuff.MOD_ID);
    public static final RegistryObject<ExampleFeature> EXAMPLE_FEATURE = FEATURES.register("example_feature",
            () -> new ExampleFeature(NoFeatureConfig.CODEC));

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres() {
        //BASE_STONE_OVERWORLD is for generating in stone, granite, diorite, and andesite
        //NETHERRACK is for generating in netherrack
        //BASE_STONE_NETHER is for generating in netherrack, basalt and blackstone

        //Overworld Ore Register
        //overworldOres.add(register("neutralis_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
        //        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandlerBlocks.NEUTRALIS_ORE.get().getDefaultState(), 4)) //Vein Size
        //        .range(64).square() //Spawn height start
        //        .func_242731_b(64))); //Chunk spawn frequency
        // overworldOres.add(register("earthy_deposit", Feature.ORE.withConfiguration(new OreFeatureConfig(
        //         new BlockMatchRuleTest(Blocks.DIRT), RegistryHandlerBlocks.EARTHY_DEPOSIT.get().getDefaultState(), 4)) //Vein Size
        //        .range(128).square() //Spawn height start
        //        .func_242731_b(64))); //Chunk spawn frequency

        //Nether Ore Register
        //  netherOres.add(register("flame_crystal_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
        //         OreFeatureConfig.FillerBlockType.NETHERRACK, RegistryHandlerBlocks.FLAME_CRYSTAL_ORE.get().getDefaultState(), 4))
        //        .range(48).square()
        //        .func_242731_b(64)));

        //The End Ore Register
        endOres.add(register("vibranium_ore", Feature.ORE.configured(new OreFeatureConfig(
                new BlockMatchRuleTest(Blocks.END_STONE), BlockInit.VIBRANIUM_ORE.get().defaultBlockState(), 4)) //Vein Size
                .range(45).squared() //Spawn height start
                .count(3))); //Chunk spawn frequency
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (event.getCategory().equals(Biome.Category.NETHER)) {
            for (ConfiguredFeature<?, ?> ore : netherOres) {
                if (ore != null) generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if (event.getCategory().equals(Biome.Category.THEEND)) {
            for (ConfiguredFeature<?, ?> ore : endOres) {
                if (ore != null) generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for (ConfiguredFeature<?, ?> ore : overworldOres) {
            if (ore != null) generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, KillersBlocksNStuff.MOD_ID + ":" + name, configuredFeature);
    }

}









