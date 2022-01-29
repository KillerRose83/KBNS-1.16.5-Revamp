package com.Killer.killersblocksnstuff.common.events;

import com.Killer.killersblocksnstuff.*;
import com.Killer.killersblocksnstuff.entity.*;
import com.Killer.killersblocksnstuff.entity.customEntities.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

@Mod.EventBusSubscriber(modid = KillersBlocksNStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KbnsEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(KbnsEntityTypes.MINI_BOSS.get(), MiniBossEntity.registerAttributes().build());
    }
}