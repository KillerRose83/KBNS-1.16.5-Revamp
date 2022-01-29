package com.Killer.killersblocksnstuff.common.events;


import com.Killer.killersblocksnstuff.core.init.*;
import com.Killer.killersblocksnstuff.entity.*;
import com.Killer.killersblocksnstuff.entity.customEntities.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(
   modid = "kbns",
   bus = Bus.FORGE
)
public class PlayerEvents {
   @SubscribeEvent
   public static void onDamageEntity(AttackEntityEvent event) {
      if (event.getEntityLiving().getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.VIBRANIUM_SWORD.get() && event.getTarget().isAlive()) {
         LivingEntity target = (LivingEntity)event.getTarget();
         target.addEffect(new EffectInstance(Effects.WITHER, 200));
      }
   }
}