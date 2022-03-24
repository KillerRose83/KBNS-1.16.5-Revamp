package com.Killer.killersblocksnstuff.data.recipes;

import com.Killer.killersblocksnstuff.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.registry.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class KbnsRecipeTypes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, KillersBlocksNStuff.MOD_ID);

    public static final RegistryObject<VibraniumForgeRecipe.Serializer> FORGE_SERIALIZER
            = RECIPE_SERIALIZER.register("forging", VibraniumForgeRecipe.Serializer::new);

    public static IRecipeType<VibraniumForgeRecipe> FORGE_RECIPE
            = new VibraniumForgeRecipe.VibraniumForgeRecipeType();


    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, VibraniumForgeRecipe.TYPE_ID, FORGE_RECIPE);
    }
}
