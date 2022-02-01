package com.Killer.killersblocksnstuff.core.init;

import java.util.function.Supplier;

import com.Killer.killersblocksnstuff.*;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
   public static final DeferredRegister BIOMES;
   public static RegistryKey TATTERED_PLAINS;

   public static RegistryKey registerBiome(String biomeName) {
      return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(KillersBlocksNStuff.MOD_ID, biomeName));
   }

   public static RegistryObject createBiome(String biomeName, Supplier biome) {
      return BIOMES.register(biomeName, biome);
   }

   public static void registerBiomes() {
      BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(TATTERED_PLAINS, 10));
   }

   static {
      BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, KillersBlocksNStuff.MOD_ID);
      createBiome("tattered_plains", BiomeMaker::theVoidBiome);
      TATTERED_PLAINS = registerBiome("tattered_plains");
   }
}
