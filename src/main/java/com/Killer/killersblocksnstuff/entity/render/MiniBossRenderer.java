package com.Killer.killersblocksnstuff.entity.render;

import com.Killer.killersblocksnstuff.*;
import com.Killer.killersblocksnstuff.entity.customEntities.*;
import com.Killer.killersblocksnstuff.entity.model.*;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class MiniBossRenderer extends MobRenderer<MiniBossEntity, MiniBossModel<MiniBossEntity>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(KillersBlocksNStuff.MOD_ID, "textures/entity/mini_boss.png");

    public MiniBossRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MiniBossModel(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(MiniBossEntity p_110775_1_) {
    return TEXTURE;
    }
}
