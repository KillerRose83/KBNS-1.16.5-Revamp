package com.Killer.killersblocksnstuff.core.init.customItems;

import com.sun.org.apache.xpath.internal.operations.*;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class VibraniumSword extends SwordItem {
    private static final double M = Math.random() ;

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


        if(M < .03F){
            attacker.addEffect(new EffectInstance(Effects.WITHER,200,2));
        }
          else{
              attacker.addEffect(new EffectInstance(Effects.DAMAGE_BOOST,200,2));
        }



        return super.hurtEnemy(stack, target, attacker);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.killersblocksnstuff.sword_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.killersblocksnstuff.sword"));
        }


    }
}
