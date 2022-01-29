package com.Killer.killersblocksnstuff.core.init.customItems;

import com.Killer.killersblocksnstuff.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;

public class VibraniumAppleFoodBase extends Item {

    public VibraniumAppleFoodBase() {
        super(new Item.Properties().tab(KillersBlocksNStuff.KBNS_TAB)
                .food
                        (new Food.Builder()

                                .nutrition(5)
                                .saturationMod(10.0F)
                                .effect(new EffectInstance(Effects.REGENERATION, 800, 1), 1.0F)
                                .effect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 1200, 1), 1.0F)
                                .effect(new EffectInstance(Effects.DAMAGE_BOOST, 2400, 1), 1.0F)
                                .effect(new EffectInstance(Effects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build()));


    }
}





