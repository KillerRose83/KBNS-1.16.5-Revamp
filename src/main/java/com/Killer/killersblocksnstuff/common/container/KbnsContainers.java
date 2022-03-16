package com.Killer.killersblocksnstuff.common.container;

import com.Killer.killersblocksnstuff.*;
import net.minecraft.inventory.container.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.common.extensions.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class KbnsContainers {
    public static DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, KillersBlocksNStuff.MOD_ID);

    public static final RegistryObject<ContainerType<VibraniumForgeContainer>> VIBRANIUM_FORGE_CONTAINER
            = CONTAINERS.register("vibranium_forge_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getCommandSenderWorld();
                return new VibraniumForgeContainer(windowId, world, pos, inv, inv.player);
            })));


    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}

