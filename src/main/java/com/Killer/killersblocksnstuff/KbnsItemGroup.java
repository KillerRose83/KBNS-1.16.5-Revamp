package com.Killer.killersblocksnstuff;

import com.Killer.killersblocksnstuff.core.init.*;
import net.minecraft.item.*;

public class KbnsItemGroup extends ItemGroup {
    KbnsItemGroup(String x0) {
            super(x0);
        }

        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.VIBRANIUM_INGOT.get());
        }
    }


