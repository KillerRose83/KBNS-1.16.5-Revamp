package com.Killer.killersblocksnstuff.common.Blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraftforge.common.*;

public class ConcreteLampWhite extends Block {
   public ConcreteLampWhite() {
      super(Properties.of(Material.STONE)
              .strength(1.8F, 1.8F)
              .sound(SoundType.STONE)
              .harvestLevel(1).harvestTool(ToolType.PICKAXE)
              .lightLevel((lightLevel) -> {
         return 15;
      }));
   }
}
