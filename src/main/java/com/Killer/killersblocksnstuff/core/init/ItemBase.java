package com.Killer.killersblocksnstuff.core.init;

import com.Killer.killersblocksnstuff.KillersBlocksNStuff;
import net.minecraft.item.Item;


public class ItemBase extends Item {
    public ItemBase() {
        super( new Item.Properties().tab(KillersBlocksNStuff.KBNS_TAB));
    }
}
