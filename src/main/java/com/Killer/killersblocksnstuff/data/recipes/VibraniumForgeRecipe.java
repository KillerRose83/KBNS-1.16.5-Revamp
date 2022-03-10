package com.Killer.killersblocksnstuff.data.recipes;

import com.Killer.killersblocksnstuff.core.init.*;
import com.google.gson.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.registries.*;

import javax.annotation.*;

public class VibraniumForgeRecipe implements IVibraniumForgeRecipe {

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public VibraniumForgeRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }


    @Override
    public boolean matches(IInventory inv, World worldIn) {
        // Checks for correct focus (Glass Pane)
        if(recipeItems.get(0).test(inv.getItem(0))) {
                return recipeItems.get(1).test(inv.getItem(1));

        }
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(IInventory p_77572_1_) {
        return output;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BlockInit.VIBRANIUM_FORGE.get());
    }

    @Override
    public ResourceLocation getId() {
        return null;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return KbnsRecipeTypes.FORGE_SERIALIZER.get();
    }

    public static class VibraniumForgeRecipeType implements IRecipeType<VibraniumForgeRecipe> {
        @Override
        public String toString() {
            return VibraniumForgeRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
            implements IRecipeSerializer<VibraniumForgeRecipe> {

        @Override
        public VibraniumForgeRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.convertToJsonObject(json, "output"));


            JsonArray ingredients = JSONUtils.convertToJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new VibraniumForgeRecipe(recipeId, output,
                    inputs);
        }
        @Nullable
        @Override
        public VibraniumForgeRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }

            ItemStack output = buffer.readItem();
            return new VibraniumForgeRecipe(recipeId, output,
                    inputs);
        }

        @Override
        public void toNetwork (PacketBuffer buffer, VibraniumForgeRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buffer);
            }
            buffer.writeItemStack(recipe.output, false);
        }
    }
}

