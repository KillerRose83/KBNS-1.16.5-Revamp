package com.Killer.killersblocksnstuff.common.world.feature;


import com.mojang.serialization.*;
import net.minecraft.block.*;
import net.minecraft.tags.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

import java.util.*;

public class ExampleFeature extends Feature<NoFeatureConfig> {

    private static final BlockState OAK_LOG = Blocks.OAK_LOG.defaultBlockState();

    public ExampleFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }
@SuppressWarnings("deprecation")
    public boolean isAirOrLeaves(IWorldGenerationBaseReader reader, BlockPos pos){
        if (!(reader instanceof IWorldReader )){
            return reader.isStateAtPosition(pos, (state) -> state.isAir() || state.is(BlockTags.LEAVES));
        }
        else {
            return reader.isStateAtPosition(pos, state -> state.canBeReplacedByLeaves((IWorldReader)reader, pos));
        }
    }

    @Override
    public boolean place(ISeedReader reader, ChunkGenerator ChunkGenerator, Random random, BlockPos pos, NoFeatureConfig config) {

        while (pos.getY() > 1 && isAirOrLeaves(reader,pos)){
            pos.below();
        }
        pos.above();

        for (int i = 0; i < 4; i++)
        setBlock(reader,pos.above(i), OAK_LOG);
        setBlock(reader,pos.below(1), OAK_LOG);
        return false;
    }
}
