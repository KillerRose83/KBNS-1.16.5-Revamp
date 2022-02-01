package com.Killer.killersblocksnstuff.entity.model;// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Killer.killersblocksnstuff.entity.customEntities.*;
import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class MiniBossModel <T extends MiniBossEntity> extends EntityModel<T> {
    private final ModelRenderer rightLeg;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer rightFoot;
    private final ModelRenderer leftLeg;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer leftFoot;
    private final ModelRenderer cube_r5;
    private final ModelRenderer body;
    private final ModelRenderer waist;
    private final ModelRenderer head;
    private final ModelRenderer headDress;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer rightArm;
    private final ModelRenderer cube_r9;
    private final ModelRenderer leftArm;
    private final ModelRenderer cube_r10;
    private final ModelRenderer rightShoulderArmor;
    private final ModelRenderer cube_r11;
    private final ModelRenderer rightSpikes;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer leftShoulderArmor;
    private final ModelRenderer cube_r15;
    private final ModelRenderer leftSpikes;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;

    public MiniBossModel() {
        texWidth = 64;
        texHeight = 64;

        rightLeg = new ModelRenderer(this);
        rightLeg.setPos(-3.0F, 6.0F, 0.0F);
        setRotationAngle(rightLeg, 0.0F, 0.0873F, 0.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(-1.0F, 7.0F, 0.0F);
        rightLeg.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.0436F, 0.0F, 0.0F);
        cube_r1.texOffs(24, 46).addBox(-1.0F, -7.0436F, -2.001F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(-1.0F, 17.0F, 0.0F);
        rightLeg.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0873F, 0.0F, 0.0F);
        cube_r2.texOffs(48, 19).addBox(-1.0F, -9.0F, -1.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        rightFoot = new ModelRenderer(this);
        rightFoot.setPos(3.0F, 18.0F, 0.0F);
        rightLeg.addChild(rightFoot);
        rightFoot.texOffs(8, 37).addBox(-5.0F, -2.0F, -4.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setPos(4.0F, 6.0F, 0.0F);
        setRotationAngle(leftLeg, 0.0F, 0.0F, -0.0436F);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(-1.349F, 6.9924F, 0.0F);
        leftLeg.addChild(cube_r3);
        setRotationAngle(cube_r3, -0.0436F, 0.0F, 0.0F);
        cube_r3.texOffs(0, 45).addBox(-1.0F, -7.0436F, -2.001F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-1.349F, 16.9924F, 0.0F);
        leftLeg.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0873F, 0.0F, 0.0F);
        cube_r4.texOffs(12, 46).addBox(-1.0F, -9.0F, -1.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        leftFoot = new ModelRenderer(this);
        leftFoot.setPos(-4.349F, 17.9924F, 0.0F);
        leftLeg.addChild(leftFoot);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(4.0F, 0.0F, 0.0F);
        leftFoot.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, 0.0436F);
        cube_r5.texOffs(36, 25).addBox(-2.0F, -2.0F, -4.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 24.0F, 0.0F);
        body.texOffs(0, 0).addBox(-6.0F, -32.0F, -3.0F, 12.0F, 5.0F, 6.0F, 0.0F, false);

        waist = new ModelRenderer(this);
        waist.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(waist);
        waist.texOffs(0, 11).addBox(-5.0F, -27.0F, -2.0F, 10.0F, 9.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, -8.0F, 0.0F);
        head.texOffs(42, 41).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

        headDress = new ModelRenderer(this);
        headDress.setPos(0.0F, 32.0F, 0.0F);
        head.addChild(headDress);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(0.0F, -37.0F, 0.0F);
        headDress.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.0873F, 0.0F, 0.0F);
        cube_r6.texOffs(37, 45).addBox(-0.5F, -7.7F, -2.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(1.0F, -37.0F, -1.0F);
        headDress.addChild(cube_r7);
        setRotationAngle(cube_r7, -0.0738F, -0.0656F, -0.0835F);
        cube_r7.texOffs(16, 24).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(-1.0F, -37.0F, -1.0F);
        headDress.addChild(cube_r8);
        setRotationAngle(cube_r8, -0.0733F, -0.0646F, 0.082F);
        cube_r8.texOffs(28, 11).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        rightArm = new ModelRenderer(this);
        rightArm.setPos(-6.0F, -7.0F, 0.0F);
        rightArm.texOffs(36, 0).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(-1.0F, 9.0F, 0.0F);
        rightArm.addChild(cube_r9);
        setRotationAngle(cube_r9, -0.1745F, 0.0F, 0.0F);
        cube_r9.texOffs(32, 33).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setPos(6.0F, -7.0F, 0.0F);
        leftArm.texOffs(0, 31).addBox(0.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(2.0F, 9.0F, 0.0F);
        leftArm.addChild(cube_r10);
        setRotationAngle(cube_r10, -0.1745F, 0.0F, 0.0F);
        cube_r10.texOffs(22, 25).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);

        rightShoulderArmor = new ModelRenderer(this);
        rightShoulderArmor.setPos(0.0F, 24.0F, 0.0F);
        rightShoulderArmor.texOffs(38, 12).addBox(-7.0F, -33.0F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(-6.0F, -32.0F, 0.0F);
        rightShoulderArmor.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, -0.5236F);
        cube_r11.texOffs(22, 18).addBox(-4.8F, -1.1F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);

        rightSpikes = new ModelRenderer(this);
        rightSpikes.setPos(0.0F, 0.0F, 0.0F);
        rightShoulderArmor.addChild(rightSpikes);


        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(-7.0F, -32.0F, 0.0F);
        rightSpikes.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0F, 0.0F, 0.5236F);
        cube_r12.texOffs(0, 24).addBox(13.0F, -11.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(-7.0F, -32.0F, 0.0F);
        rightSpikes.addChild(cube_r13);
        setRotationAngle(cube_r13, -0.2618F, 0.0F, -0.5236F);
        cube_r13.texOffs(30, 0).addBox(-1.0F, -3.0F, 0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(-7.0F, -32.0F, 0.0F);
        rightSpikes.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.2618F, 0.0F, -0.5236F);
        cube_r14.texOffs(20, 25).addBox(-1.0F, -3.0F, -1.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        leftShoulderArmor = new ModelRenderer(this);
        leftShoulderArmor.setPos(0.0F, 24.0F, 0.0F);
        leftShoulderArmor.texOffs(20, 39).addBox(4.0F, -33.0F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(6.0F, -32.0F, 0.0F);
        leftShoulderArmor.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.0F, 0.5236F);
        cube_r15.texOffs(0, 24).addBox(0.0F, -1.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);

        leftSpikes = new ModelRenderer(this);
        leftSpikes.setPos(15.0F, 0.0F, 0.0F);
        leftShoulderArmor.addChild(leftSpikes);


        cube_r16 = new ModelRenderer(this);
        cube_r16.setPos(-6.0F, -32.0F, 0.0F);
        leftSpikes.addChild(cube_r16);
        setRotationAngle(cube_r16, -0.2618F, 0.0F, 0.5236F);
        cube_r16.texOffs(0, 11).addBox(-0.9F, -2.0F, 0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setPos(-22.0F, -32.0F, 0.0F);
        leftSpikes.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.2618F, 0.0F, 0.5236F);
        cube_r17.texOffs(24, 11).addBox(13.0F, -10.0F, 0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setPos(-22.0F, -32.0F, 0.0F);
        leftSpikes.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.0F, 0.0F, -0.5236F);
        cube_r18.texOffs(0, 0).addBox(-1.0F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.rightLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6762F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.leftLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6762F) * 1.4F * p_225597_3_;
    }


    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
        leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}