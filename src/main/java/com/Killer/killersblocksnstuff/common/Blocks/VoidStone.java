package com.Killer.killersblocksnstuff.common.Blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraftforge.common.*;

public class VoidStone extends Block {
   public VoidStone() {
      super(Properties.of(Material.GLASS).strength(0.2F, 3.0F).sound(SoundType.GLASS).harvestLevel(0).harvestTool(ToolType.PICKAXE).harvestTool(ToolType.AXE).harvestTool(ToolType.SHOVEL).harvestTool(ToolType.HOE).lightLevel((lightLevel) -> {
         return 15;
      }));
   }
}
