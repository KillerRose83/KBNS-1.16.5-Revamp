package com.Killer.killersblocksnstuff.util.enums;


import java.util.function.Supplier;

import com.Killer.killersblocksnstuff.core.init.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum KbnsArmorMaterial implements IArmorMaterial {
   VIBRANIUM("kbns:vibranium", 1000, new int[]{5, 8, 11, 5}, 23, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0.2F, () -> {
      return Ingredient.of(ItemInit.VIBRANIUM_INGOT.get());
   });

   private static final int[] baseDurability = new int[]{11, 16, 15, 13};
   private final String name;
   private final int durabilityMultiplier;
   private final int[] armorVal;
   private final int enchantability;
   private final SoundEvent SoundEvent;
   private final float toughness;
   private final float knockbackResistance;
   private final Ingredient repairIngredient;

   private KbnsArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier repairIngredient) {
      this.name = name;
      this.durabilityMultiplier = maxDamageFactor;
      this.armorVal = damageReductionAmountArray;
      this.enchantability = enchantability;
      this.SoundEvent = soundEvent;
      this.toughness = toughness;
      this.knockbackResistance = knockbackResistance;
      this.repairIngredient = (Ingredient)repairIngredient.get();
   }

   @Override
   public int getDurabilityForSlot(EquipmentSlotType slot) {
      return baseDurability[slot.getIndex()] * this.durabilityMultiplier;
   }

   @Override
   public int getDefenseForSlot(EquipmentSlotType slot) {
      return this.armorVal[slot.getIndex()];
   }

   @Override
   public int getEnchantmentValue()  {
      return this.enchantability;
   }

   @Override
   public net.minecraft.util.SoundEvent getEquipSound() {
      return this.SoundEvent;
   }

   @Override
   public Ingredient getRepairIngredient()  {
      return this.repairIngredient;
   }

   @Override
   public String getName()  {
      return this.name;
   }

   @Override
   public float getToughness()  {
      return this.toughness;
   }

   @Override
   public float getKnockbackResistance()  {
      return this.knockbackResistance;
   }
}
