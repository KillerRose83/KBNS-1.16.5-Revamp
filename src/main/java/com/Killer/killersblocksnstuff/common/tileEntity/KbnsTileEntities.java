package com.Killer.killersblocksnstuff.common.tileEntity;

import com.Killer.killersblocksnstuff.*;
import com.Killer.killersblocksnstuff.core.init.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class KbnsTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, KillersBlocksNStuff.MOD_ID);

    public static RegistryObject<TileEntityType<VibraniumForgeTile>> VIBRANIUM_FORGE_TILE =
            TILE_ENTITIES.register("vibranium_forge_tile", () -> TileEntityType.Builder.of(
                    VibraniumForgeTile::new, BlockInit.VIBRANIUM_FORGE.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}