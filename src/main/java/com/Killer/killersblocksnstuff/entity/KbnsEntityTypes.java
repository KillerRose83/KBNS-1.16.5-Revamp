package com.Killer.killersblocksnstuff.entity;

import com.Killer.killersblocksnstuff.*;
import com.Killer.killersblocksnstuff.entity.customEntities.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class KbnsEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, KillersBlocksNStuff.MOD_ID);

    public static final RegistryObject<EntityType<MiniBossEntity>> MINI_BOSS =
            ENTITY_TYPES.register("mini_boss",
                    () -> EntityType.Builder.of(MiniBossEntity::new,
                            EntityClassification.MONSTER).sized(1f,3f)
                            .build(new ResourceLocation(KillersBlocksNStuff.MOD_ID, "mini_boss").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
