package com.Killer.killersblocksnstuff.core.init;

import com.Killer.killersblocksnstuff.common.world.surface.KbnsSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit {
   public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS;
   public static final RegistryObject<SurfaceBuilder<?>> KBNS_SURFACE;

   static {
      SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, "killersblocksnstuff");
      KBNS_SURFACE = SURFACE_BUILDERS.register("surface", () -> {
         return new KbnsSurfaceBuilder(SurfaceBuilderConfig.CODEC);
      });
   }
}
