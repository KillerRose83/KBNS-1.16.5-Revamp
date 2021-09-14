package com.Killer.killersblocksnstuff.common.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RefinedVibraniumPowderBlock extends Block {
   public RefinedVibraniumPowderBlock() {
      super(Properties.of(Material.METAL).strength(4.0F, -1.0F).sound(SoundType.NETHER_BRICKS).harvestLevel(3).harvestTool(ToolType.PICKAXE));
   }
}
