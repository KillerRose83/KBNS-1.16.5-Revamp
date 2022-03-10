package com.Killer.killersblocksnstuff.data.recipes;

import com.Killer.killersblocksnstuff.*;
import net.minecraft.inventory.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;

public interface IVibraniumForgeRecipe extends IRecipe<IInventory> {
    ResourceLocation TYPE_ID = new ResourceLocation(KillersBlocksNStuff.MOD_ID, "forge");

    @Override
    default IRecipeType<?> getType(){
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }

    @Override
    default boolean isSpecial() {
        return true;
    }
}
