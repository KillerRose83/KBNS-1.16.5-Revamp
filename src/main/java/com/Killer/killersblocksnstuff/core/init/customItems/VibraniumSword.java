package com.Killer.killersblocksnstuff.core.init.customItems;

import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;

public class VibraniumSword extends SwordItem {
    public VibraniumSword(IItemTier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Here we can add effects on hit with this weapon to the target
        attacker.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 60));
        target.addEffect(new EffectInstance(Effects.WITHER, 200));
        target.addEffect(new EffectInstance(Effects.WEAKNESS, 200, 2));
        target.setSecondsOnFire(3);
        return super.hurtEnemy(stack, target, attacker);
    }
}
