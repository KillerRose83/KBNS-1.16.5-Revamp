package com.Killer.killersblocksnstuff.integration.jei;

import com.Killer.killersblocksnstuff.*;
import com.Killer.killersblocksnstuff.core.init.*;
import com.Killer.killersblocksnstuff.data.recipes.*;
import mezz.jei.api.constants.*;
import mezz.jei.api.gui.*;
import mezz.jei.api.gui.drawable.*;
import mezz.jei.api.helpers.*;
import mezz.jei.api.ingredients.*;
import mezz.jei.api.recipe.category.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class ForgeRecipeJei implements IRecipeCategory<VibraniumForgeRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(KillersBlocksNStuff.MOD_ID, "forge");
    public static final ResourceLocation TEXTURE = new ResourceLocation(KillersBlocksNStuff.MOD_ID, "textures/gui/vibranium_forge_gui.png");


    private final IDrawable background;
    private final IDrawable icon;
    private final String title = "Forging";

    public ForgeRecipeJei(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(new ItemStack(BlockInit.VIBRANIUM_FORGE.get()));
    }


    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends VibraniumForgeRecipe> getRecipeClass() {
        return VibraniumForgeRecipe.class;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients(VibraniumForgeRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, VibraniumForgeRecipe recipe, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0,true, 55, 16);
        recipeLayout.getItemStacks().init(1,true, 55, 52);
        recipeLayout.getItemStacks().init(2,false, 115, 34);

        recipeLayout.getItemStacks().set(ingredients);
    }
}
