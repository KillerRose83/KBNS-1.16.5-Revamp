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
    public int craftTime;
    private final NonNullList<Ingredient> ingredients;

    public VibraniumForgeRecipe(ResourceLocation id, ItemStack output, int craftTime, NonNullList<Ingredient> ingredients) {
        this.id = id;
        this.output = output;
        this.craftTime = craftTime;
        this.ingredients = ingredients;
    }


    @Override
    public boolean matches(IInventory inv, World worldIn) {
        if(ingredients.get(0).test(inv.getItem(0))) {
            return ingredients.get(1).test(inv.getItem(1));
        }

        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public ItemStack assemble(IInventory inv) {
        return output;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    public ItemStack getIcon() {
        return new ItemStack(BlockInit.VIBRANIUM_FORGE.get());
    }

    public int getCraftTime() {
        return craftTime;
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

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<VibraniumForgeRecipe> {

        @Override
        public VibraniumForgeRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "output"));
            int craftTime = JSONUtils.getAsInt(json, "craftTime");
            JsonArray ingredients = JSONUtils.getAsJsonArray(json, "ingredients");

            NonNullList<Ingredient> inputs = NonNullList.create();
            for (JsonElement element : ingredients) {
                inputs.add(Ingredient.fromJson(element));
            }

            return new VibraniumForgeRecipe(recipeId, output, craftTime, inputs);
        }

        @Nullable
        @Override
        public VibraniumForgeRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            Ingredient[] ings = new Ingredient[buffer.readVarInt()];
            NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(),Ingredient.EMPTY);
            for (int i = 0; i < ings.length; i++) {
                inputs.add(i, ings[i]);
            }

            ItemStack output = buffer.readItem();
            int craftTime = buffer.readVarInt();
            return new VibraniumForgeRecipe(recipeId, output, craftTime, inputs);
        }

        @Override
        public void toNetwork(PacketBuffer buffer, VibraniumForgeRecipe recipe) {
            buffer.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeItemStack(recipe.getResultItem(), false);
            buffer.writeVarInt(recipe.getCraftTime());
        }
    }


}

