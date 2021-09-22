package com.Killer.killersblocksnstuff.util.enums;


import java.util.function.Supplier;

import com.Killer.killersblocksnstuff.core.init.*;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;


public enum KbnsItemTier implements IItemTier {
   VIBRANIUM(8, 2600, 12.0F, 8.0F, 35, () -> {
      return Ingredient.of(ItemInit.VIBRANIUM_INGOT.get());
   });

   private final int harvestlevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final Ingredient repairMaterial;

   private KbnsItemTier(int harvestlevel, int maxUses, float effeciency, float attackDamage, int enchantability, Supplier repairMaterial) {
      this.harvestlevel = harvestlevel;
      this.maxUses = maxUses;
      this.efficiency = effeciency;
      this.attackDamage = attackDamage;
      this.enchantability = enchantability;
      this.repairMaterial = (Ingredient)repairMaterial.get();
   }

   @Override
   public int getUses()  {
      return this.maxUses;
   }

   @Override
   public float getSpeed()  {
      return this.efficiency;
   }

   @Override
   public float getAttackDamageBonus() {
      return this.attackDamage;
   }

   @Override
   public int getLevel()  {
      return this.harvestlevel;
   }

   @Override
   public int getEnchantmentValue()  {
      return this.enchantability;
   }

   @Override
   public Ingredient getRepairIngredient()  {
      return this.repairMaterial;
   }
}
