package com.Killer.killersblocksnstuff.common.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ConcreteLampRed extends Block {
   public ConcreteLampRed() {
      super(Properties.of(Material.STONE).strength(1.8F, 1.8F)
              .sound(SoundType.STONE)
              .harvestLevel(1).harvestTool(ToolType.PICKAXE)
              .lightLevel((lightLevel) -> {
         return 15;
      }));
   }
}
