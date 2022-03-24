package com.Killer.killersblocksnstuff.core.init.customItems;

import com.Killer.killersblocksnstuff.*;
import net.minecraft.block.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.util.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ForgeBlockItem extends BlockItem {

    public ForgeBlockItem(Block block) {
        super(block, new Item.Properties().tab(KillersBlocksNStuff.KBNS_TAB));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.killersblocksnstuff.forge_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.killersblocksnstuff.forge"));
        }

    }
}
