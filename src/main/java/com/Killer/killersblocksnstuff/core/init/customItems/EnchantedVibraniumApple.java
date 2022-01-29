package com.Killer.killersblocksnstuff.core.init.customItems;

import com.Killer.killersblocksnstuff.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.util.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class EnchantedVibraniumApple extends Item {

    public EnchantedVibraniumApple() {
        super(new Item.Properties().tab(KillersBlocksNStuff.KBNS_TAB)
                .food(new Food.Builder()

                                .nutrition(5)
                                .saturationMod(10.0F)
                                .effect(new EffectInstance(Effects.REGENERATION, 800, 1), 1.0F)
                                .effect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 2400, 1), 1.0F)
                                .effect(new EffectInstance(Effects.DAMAGE_BOOST, 2400, 2), .5F)
                                .effect(new EffectInstance(Effects.BLINDNESS, 300, 0), .01F)
                                .effect(new EffectInstance(Effects.ABSORPTION, 3600, 2), 1.0F).alwaysEat().build()));


    }
    public boolean isFoil(ItemStack p_77636_1_) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.kbns.enchantedapple_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.kbns.enchantedapple"));
        }


    }
}

