package com.Killer.killersblocksnstuff.core.init;

import com.Killer.killersblocksnstuff.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().tab(KillersBlocksNStuff.KBNS_TAB));
    }
}