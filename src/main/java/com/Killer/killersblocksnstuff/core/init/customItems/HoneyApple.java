package com.Killer.killersblocksnstuff.core.init.customItems;

import com.Killer.killersblocksnstuff.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.util.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class HoneyApple extends Item {

    public HoneyApple() {
        super(new Item.Properties().tab(KillersBlocksNStuff.KBNS_TAB)
                .food(new Food.Builder()


                        .effect(new EffectInstance(Effects.DIG_SPEED, 1800, 1), 1.0F)
                        .effect(new EffectInstance(Effects.MOVEMENT_SPEED, 1800, 0), 1.0F).alwaysEat().build()));


    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.killersblocksnstuff.haste_food_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.killersblocksnstuff.haste_food"));
        }


    }
}
