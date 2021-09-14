package com.Killer.killersblocksnstuff.common.Blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraftforge.common.*;

public class VibraniumOre extends OreBlock {
   public VibraniumOre() {
      super(Properties.of(Material.STONE).strength(10.0F, 100.0F).sound(SoundType.STONE).harvestLevel(3).harvestTool(ToolType.PICKAXE));
   }
}
