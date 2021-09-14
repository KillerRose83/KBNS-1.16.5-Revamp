package com.Killer.killersblocksnstuff.common.world.surface;

import com.mojang.serialization.Codec;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.*;

public class KbnsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    public static final BlockState GRASS = Blocks.GRASS_BLOCK.defaultBlockState();
    public static final BlockState DIRT = Blocks.DIRT.defaultBlockState();
    public static final BlockState COARSE_DIRT = Blocks.COARSE_DIRT.defaultBlockState();

    public static final SurfaceBuilderConfig EXAMPLE_BLOCK_CONFIG = new SurfaceBuilderConfig(GRASS,
            DIRT, DIRT);
    public static final SurfaceBuilderConfig STONE_CONFIG = new SurfaceBuilderConfig(COARSE_DIRT, COARSE_DIRT, COARSE_DIRT);

    public KbnsSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
        super(codec);
    }

   @Override
   public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                            BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
      if (random.nextInt(2) == 0) {
         SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                 defaultFluid, seaLevel, seed, EXAMPLE_BLOCK_CONFIG);
      } else {
         SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
                 defaultFluid, seaLevel, seed, STONE_CONFIG);
      }
   }
}



