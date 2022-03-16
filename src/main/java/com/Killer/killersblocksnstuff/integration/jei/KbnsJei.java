package com.Killer.killersblocksnstuff.integration.jei;

import com.Killer.killersblocksnstuff.*;
import com.Killer.killersblocksnstuff.data.recipes.*;
import mezz.jei.api.*;
import mezz.jei.api.registration.*;
import net.minecraft.client.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.*;

import java.util.*;
import java.util.stream.*;

@JeiPlugin
public class KbnsJei implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(KillersBlocksNStuff.MOD_ID, "jei_plugin");
    }


    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new ForgeRecipeJei(registration.getJeiHelpers().getGuiHelper())
        );
    }


    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        registration.addRecipes(rm.getAllRecipesFor(KbnsRecipeTypes.FORGE_RECIPE).stream()
                        .filter(r -> r instanceof VibraniumForgeRecipe).collect(Collectors.toList()),
                ForgeRecipeJei.UID);
    }
}
