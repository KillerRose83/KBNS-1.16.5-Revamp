package com.Killer.killersblocksnstuff.container.screen;

import com.Killer.killersblocksnstuff.*;
import com.Killer.killersblocksnstuff.common.tileEntity.*;
import com.Killer.killersblocksnstuff.container.*;
import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.systems.*;
import net.minecraft.client.gui.screen.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

public class VibraniumForgeScreen extends ContainerScreen<VibraniumForgeContainer> {
    private final ResourceLocation GUI = new ResourceLocation(KillersBlocksNStuff.MOD_ID,
            "textures/gui/vibranium_forge_gui.png");

    protected int width = 176;
    protected int height = 166;

    public VibraniumForgeScreen(VibraniumForgeContainer p_i51105_1_, PlayerInventory p_i51105_2_, ITextComponent p_i51105_3_) {
        super(p_i51105_1_, p_i51105_2_, p_i51105_3_);
    }


    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bind(GUI);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(matrixStack, i, j, 0, 0, this.width, this.height);

    }
}
