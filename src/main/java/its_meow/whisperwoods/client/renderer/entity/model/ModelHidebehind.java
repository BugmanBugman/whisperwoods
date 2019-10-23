package its_meow.whisperwoods.client.renderer.entity.model;

import com.mojang.blaze3d.platform.GlStateManager;

import its_meow.whisperwoods.entity.EntityHidebehind;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

/**
 * hidebehind - cybercat5555
 * Created using Tabula 7.0.1
 */
public class ModelHidebehind extends EntityModel<EntityHidebehind> {
    public RendererModel chest;
    public RendererModel stomach;
    public RendererModel neck00;
    public RendererModel lArm01;
    public RendererModel rArm01;
    public RendererModel chestFur;
    public RendererModel chestFurLower;
    public RendererModel hips;
    public RendererModel lLeg01;
    public RendererModel rLeg01;
    public RendererModel tail00;
    public RendererModel crothFur;
    public RendererModel lLeg02;
    public RendererModel lLeg01Fur;
    public RendererModel lLeg03;
    public RendererModel lLeg02Fur;
    public RendererModel lLeg02FurMid;
    public RendererModel lPaw;
    public RendererModel lToe00;
    public RendererModel lToe01;
    public RendererModel lToe02;
    public RendererModel rLeg02;
    public RendererModel rLeg01Fur;
    public RendererModel rLeg03;
    public RendererModel rLeg02Fur;
    public RendererModel rLeg02FurMid;
    public RendererModel rPaw;
    public RendererModel rToe00;
    public RendererModel rToe01;
    public RendererModel rToe02;
    public RendererModel tail01;
    public RendererModel neck01;
    public RendererModel head;
    public RendererModel lowerJawOpen;
    public RendererModel lowerJawClosed;
    public RendererModel lEar;
    public RendererModel rEar;
    public RendererModel lArm02;
    public RendererModel lClaw00;
    public RendererModel lClaw01;
    public RendererModel lClaw02;
    public RendererModel lArmFur;
    public RendererModel rArm02;
    public RendererModel rClaw00;
    public RendererModel rClaw01;
    public RendererModel rClaw02;
    public RendererModel rArmFur;

    public ModelHidebehind() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.rArmFur = new RendererModel(this, 78, 75);
        this.rArmFur.setRotationPoint(0.0F, 8.2F, -1.2F);
        this.rArmFur.addBox(-2.01F, -7.5F, 0.5F, 4, 15, 7, 0.0F);
        this.setRotateAngle(rArmFur, -0.3490658503988659F, 0.0F, 0.0F);
        this.rArm01 = new RendererModel(this, 90, 0);
        this.rArm01.mirror = true;
        this.rArm01.setRotationPoint(-7.5F, -9.4F, 0.5F);
        this.rArm01.addBox(-2.0F, -1.5F, -2.5F, 4, 17, 4, 0.0F);
        this.setRotateAngle(rArm01, -0.08726646259971647F, 0.0F, 0.12217304763960307F);
        this.rToe00 = new RendererModel(this, 0, 116);
        this.rToe00.mirror = true;
        this.rToe00.setRotationPoint(-1.4F, 0.0F, -2.5F);
        this.rToe00.addBox(-0.5F, -0.9F, -4.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(rToe00, 0.17453292519943295F, 0.13962634015954636F, 0.0F);
        this.lClaw02 = new RendererModel(this, 0, 0);
        this.lClaw02.setRotationPoint(0.6F, 19.8F, 1.5F);
        this.lClaw02.addBox(-1.1F, -1.5F, -0.5F, 3, 7, 1, 0.0F);
        this.setRotateAngle(lClaw02, 0.10471975511965977F, 0.0F, 0.22689280275926282F);
        this.chestFur = new RendererModel(this, 81, 42);
        this.chestFur.setRotationPoint(0.0F, -7.8F, -0.4F);
        this.chestFur.addBox(-7.0F, 0.0F, -4.5F, 14, 18, 9, 0.0F);
        this.setRotateAngle(chestFur, -0.45378560551852565F, 0.0F, 0.0F);
        this.head = new RendererModel(this, 41, 15);
        this.head.setRotationPoint(0.0F, -6.4F, -0.1F);
        this.head.addBox(-5.5F, -6.5F, -7.1F, 11, 16, 10, 0.0F);
        this.setRotateAngle(head, -0.41887902047863906F, 0.0F, 0.0F);
        this.rClaw01 = new RendererModel(this, 0, 0);
        this.rClaw01.mirror = true;
        this.rClaw01.setRotationPoint(-0.6F, 19.8F, 0.0F);
        this.rClaw01.addBox(-1.8F, -1.5F, -0.5F, 3, 7, 1, 0.0F);
        this.setRotateAngle(rClaw01, 0.0F, 0.0F, -0.22689280275926282F);
        this.rLeg03 = new RendererModel(this, 0, 94);
        this.rLeg03.mirror = true;
        this.rLeg03.setRotationPoint(0.0F, -0.3F, 14.3F);
        this.rLeg03.addBox(-2.0F, -0.9F, -1.5F, 4, 9, 3, 0.0F);
        this.setRotateAngle(rLeg03, 0.6981317007977318F, 0.0F, 0.0F);
        this.lArm01 = new RendererModel(this, 90, 0);
        this.lArm01.setRotationPoint(7.5F, -9.4F, 0.5F);
        this.lArm01.addBox(-2.0F, -1.5F, -2.5F, 4, 18, 4, 0.0F);
        this.setRotateAngle(lArm01, -0.08726646259971647F, 0.0F, -0.12217304763960307F);
        this.lArmFur = new RendererModel(this, 78, 75);
        this.lArmFur.setRotationPoint(0.0F, 8.2F, -1.2F);
        this.lArmFur.addBox(-1.9F, -7.5F, 0.5F, 4, 15, 7, 0.0F);
        this.setRotateAngle(lArmFur, -0.3490658503988659F, 0.0F, 0.0F);
        this.rLeg01 = new RendererModel(this, 0, 62);
        this.rLeg01.mirror = true;
        this.rLeg01.setRotationPoint(-5.5F, 2.0F, -0.4F);
        this.rLeg01.addBox(-2.5F, -1.5F, -2.5F, 5, 24, 7, 0.0F);
        this.setRotateAngle(rLeg01, -0.6108652381980153F, 0.13962634015954636F, 0.0F);
        this.lClaw00 = new RendererModel(this, 0, 0);
        this.lClaw00.setRotationPoint(0.6F, 19.8F, -1.5F);
        this.lClaw00.addBox(-1.1F, -1.5F, -0.5F, 3, 7, 1, 0.0F);
        this.setRotateAngle(lClaw00, -0.10471975511965977F, 0.0F, 0.22689280275926282F);
        this.lToe00 = new RendererModel(this, 0, 116);
        this.lToe00.setRotationPoint(1.4F, 0.0F, -2.5F);
        this.lToe00.addBox(-0.5F, -0.9F, -4.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(lToe00, 0.17453292519943295F, -0.13962634015954636F, 0.0F);
        this.lToe01 = new RendererModel(this, 0, 116);
        this.lToe01.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.lToe01.addBox(-0.5F, -0.9F, -4.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(lToe01, 0.17453292519943295F, 0.0F, 0.0F);
        this.lPaw = new RendererModel(this, 14, 116);
        this.lPaw.setRotationPoint(0.0F, 7.2F, 0.0F);
        this.lPaw.addBox(-2.5F, 0.0F, -3.5F, 5, 2, 5, 0.0F);
        this.setRotateAngle(lPaw, 0.22689280275926282F, 0.0F, 0.0F);
        this.rPaw = new RendererModel(this, 14, 116);
        this.rPaw.mirror = true;
        this.rPaw.setRotationPoint(0.0F, 7.2F, 0.0F);
        this.rPaw.addBox(-2.5F, 0.0F, -3.5F, 5, 2, 5, 0.0F);
        this.setRotateAngle(rPaw, 0.22689280275926282F, 0.0F, 0.0F);
        this.hips = new RendererModel(this, 0, 47);
        this.hips.setRotationPoint(0.0F, 14.9F, 0.0F);
        this.hips.addBox(-6.0F, 0.0F, -3.0F, 12, 6, 7, 0.0F);
        this.setRotateAngle(hips, -0.2617993877991494F, 0.0F, 0.0F);
        this.rLeg01Fur = new RendererModel(this, 44, 73);
        this.rLeg01Fur.mirror = true;
        this.rLeg01Fur.setRotationPoint(0.0F, 7.5F, -1.5F);
        this.rLeg01Fur.addBox(-2.51F, -9.0F, 0.0F, 5, 14, 10, 0.0F);
        this.setRotateAngle(rLeg01Fur, -0.7853981633974483F, 0.0F, 0.0F);
        this.neck00 = new RendererModel(this, 46, 0);
        this.neck00.setRotationPoint(0.0F, -8.8F, 0.8F);
        this.neck00.addBox(-4.0F, -8.0F, -3.5F, 8, 8, 7, 0.0F);
        this.setRotateAngle(neck00, 0.3141592653589793F, 0.0F, 0.0F);
        this.lLeg01 = new RendererModel(this, 0, 62);
        this.lLeg01.setRotationPoint(5.5F, 2.0F, -0.4F);
        this.lLeg01.addBox(-2.5F, -1.5F, -2.5F, 5, 24, 7, 0.0F);
        this.setRotateAngle(lLeg01, -0.6108652381980153F, -0.13962634015954636F, 0.0F);
        this.neck01 = new RendererModel(this, 46, 0);
        this.neck01.setRotationPoint(0.0F, -6.8F, 0.0F);
        this.neck01.addBox(-4.0F, -8.0F, -3.5F, 8, 8, 7, 0.0F);
        this.setRotateAngle(neck01, -0.3141592653589793F, 0.0F, 0.0F);
        this.rLeg02Fur = new RendererModel(this, 45, 98);
        this.rLeg02Fur.mirror = true;
        this.rLeg02Fur.setRotationPoint(0.0F, -0.7F, 1.9F);
        this.rLeg02Fur.addBox(-2.01F, 0.0F, -5.5F, 4, 8, 9, 0.0F);
        this.setRotateAngle(rLeg02Fur, 0.7853981633974483F, 0.0F, 0.0F);
        this.rLeg02 = new RendererModel(this, 0, 94);
        this.rLeg02.mirror = true;
        this.rLeg02.setRotationPoint(0.0F, 20.0F, 1.1F);
        this.rLeg02.addBox(-2.0F, -2.5F, 0.0F, 4, 5, 15, 0.0F);
        this.setRotateAngle(rLeg02, -0.3141592653589793F, 0.0F, 0.0F);
        this.chestFurLower = new RendererModel(this, 82, 42);
        this.chestFurLower.setRotationPoint(0.0F, 1.3F, 0.6F);
        this.chestFurLower.addBox(-6.0F, 0.0F, -4.5F, 12, 18, 9, 0.0F);
        this.setRotateAngle(chestFurLower, -0.45378560551852565F, 0.0F, 0.0F);
        this.rLeg02FurMid = new RendererModel(this, 74, 91);
        this.rLeg02FurMid.mirror = true;
        this.rLeg02FurMid.setRotationPoint(-0.0F, 0.6F, 3.4F);
        this.rLeg02FurMid.addBox(0.0F, 0.0F, -5.5F, 0, 8, 16, 0.0F);
        this.setRotateAngle(rLeg02FurMid, 0.3490658503988659F, 0.0F, 0.0F);
        this.rEar = new RendererModel(this, 75, 16);
        this.rEar.mirror = true;
        this.rEar.setRotationPoint(-4.2F, -5.3F, 0.0F);
        this.rEar.addBox(-5.0F, -2.0F, -1.5F, 5, 3, 2, 0.0F);
        this.setRotateAngle(rEar, 0.3490658503988659F, -0.3490658503988659F, 1.2217304763960306F);
        this.rClaw02 = new RendererModel(this, 0, 0);
        this.rClaw02.mirror = true;
        this.rClaw02.setRotationPoint(-0.6F, 19.8F, 1.5F);
        this.rClaw02.addBox(-1.8F, -1.5F, -0.5F, 3, 7, 1, 0.0F);
        this.setRotateAngle(rClaw02, 0.10471975511965977F, 0.0F, -0.22689280275926282F);
        this.chest = new RendererModel(this, 0, 0);
        this.chest.setRotationPoint(0.0F, -31.5F, 0.0F);
        this.chest.addBox(-7.0F, -10.0F, -4.5F, 14, 13, 9, 0.0F);
        this.setRotateAngle(chest, 0.45378560551852565F, 0.0F, 0.0F);
        this.lLeg02Fur = new RendererModel(this, 45, 98);
        this.lLeg02Fur.setRotationPoint(0.0F, -0.7F, 1.9F);
        this.lLeg02Fur.addBox(-1.99F, 0.0F, -5.5F, 4, 8, 9, 0.0F);
        this.setRotateAngle(lLeg02Fur, 0.7853981633974483F, 0.0F, 0.0F);
        this.rArm02 = new RendererModel(this, 90, 0);
        this.rArm02.mirror = true;
        this.rArm02.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.rArm02.addBox(-1.9F, 0.0F, -2.0F, 4, 20, 4, 0.0F);
        this.setRotateAngle(rArm02, -0.5235987755982988F, 0.0F, 0.0F);
        this.tail00 = new RendererModel(this, 25, 69);
        this.tail00.setRotationPoint(0.0F, 2.7F, 3.1F);
        this.tail00.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 3, 0.0F);
        this.setRotateAngle(tail00, 0.12217304763960307F, 0.0F, 0.0F);
        this.tail01 = new RendererModel(this, 25, 77);
        this.tail01.setRotationPoint(0.0F, 0.3F, 2.1F);
        this.tail01.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 5, 0.0F);
        this.setRotateAngle(tail01, 0.3141592653589793F, 0.0F, 0.0F);
        this.lEar = new RendererModel(this, 75, 16);
        this.lEar.setRotationPoint(4.2F, -5.3F, 0.0F);
        this.lEar.addBox(0.0F, -2.0F, -1.2F, 5, 3, 2, 0.0F);
        this.setRotateAngle(lEar, 0.3490658503988659F, 0.3490658503988659F, -1.2217304763960306F);
        this.stomach = new RendererModel(this, 0, 23);
        this.stomach.setRotationPoint(0.0F, 2.3F, 0.6F);
        this.stomach.addBox(-5.0F, 0.0F, -3.0F, 10, 16, 6, 0.0F);
        this.setRotateAngle(stomach, -0.18203784098300857F, 0.0F, 0.0F);
        this.lLeg01Fur = new RendererModel(this, 44, 71);
        this.lLeg01Fur.setRotationPoint(0.0F, 7.5F, -1.5F);
        this.lLeg01Fur.addBox(-2.49F, -9.0F, 0.0F, 5, 14, 10, 0.0F);
        this.setRotateAngle(lLeg01Fur, -0.7853981633974483F, 0.0F, 0.0F);
        this.lClaw01 = new RendererModel(this, 0, 0);
        this.lClaw01.setRotationPoint(0.6F, 19.8F, 0.0F);
        this.lClaw01.addBox(-1.1F, -1.5F, -0.5F, 3, 7, 1, 0.0F);
        this.setRotateAngle(lClaw01, 0.0F, 0.0F, 0.22689280275926282F);
        this.rToe02 = new RendererModel(this, 0, 116);
        this.rToe02.mirror = true;
        this.rToe02.setRotationPoint(1.4F, 0.0F, -2.5F);
        this.rToe02.addBox(-0.5F, -0.9F, -4.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(rToe02, 0.17453292519943295F, -0.13962634015954636F, 0.0F);
        this.lowerJawOpen = new RendererModel(this, 38, 41);
        this.lowerJawOpen.setRotationPoint(0.0F, 1.7F, -4.5F);
        this.lowerJawOpen.addBox(-5.0F, -1.9F, -8.4F, 10, 4, 9, 0.0F);
        this.setRotateAngle(lowerJawOpen, 0.785398F, 0.0F, 0.0F);
        this.lLeg03 = new RendererModel(this, 0, 94);
        this.lLeg03.setRotationPoint(0.0F, -0.3F, 14.3F);
        this.lLeg03.addBox(-2.0F, -0.9F, -1.5F, 4, 9, 3, 0.0F);
        this.setRotateAngle(lLeg03, 0.6981317007977318F, 0.0F, 0.0F);
        this.lLeg02FurMid = new RendererModel(this, 74, 91);
        this.lLeg02FurMid.setRotationPoint(-0.0F, 0.6F, 3.4F);
        this.lLeg02FurMid.addBox(0.0F, 0.0F, -5.5F, 0, 8, 16, 0.0F);
        this.setRotateAngle(lLeg02FurMid, 0.3490658503988659F, 0.0F, 0.0F);
        this.rClaw00 = new RendererModel(this, 0, 0);
        this.rClaw00.mirror = true;
        this.rClaw00.setRotationPoint(-0.6F, 19.8F, -1.5F);
        this.rClaw00.addBox(-1.8F, -1.5F, -0.5F, 3, 7, 1, 0.0F);
        this.setRotateAngle(rClaw00, -0.10471975511965977F, 0.0F, -0.22689280275926282F);
        this.lToe02 = new RendererModel(this, 0, 116);
        this.lToe02.setRotationPoint(-1.4F, 0.0F, -2.5F);
        this.lToe02.addBox(-0.5F, -0.9F, -4.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(lToe02, 0.17453292519943295F, 0.13962634015954636F, 0.0F);
        this.lArm02 = new RendererModel(this, 90, 0);
        this.lArm02.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.lArm02.addBox(-2.0F, 0.0F, -2.0F, 4, 20, 4, 0.0F);
        this.setRotateAngle(lArm02, -0.5235987755982988F, 0.0F, 0.0F);
        this.lLeg02 = new RendererModel(this, 0, 94);
        this.lLeg02.setRotationPoint(0.0F, 20.0F, 1.3F);
        this.lLeg02.addBox(-2.0F, -2.5F, 0.0F, 4, 5, 15, 0.0F);
        this.setRotateAngle(lLeg02, -0.3141592653589793F, 0.0F, 0.0F);
        this.lowerJawClosed = new RendererModel(this, 38, 55);
        this.lowerJawClosed.setRotationPoint(0.0F, 3.4F, -4.5F);
        this.lowerJawClosed.addBox(-5.0F, -3.0F, -2.4F, 10, 4, 9, 0.0F);
        this.crothFur = new RendererModel(this, 88, 43);
        this.crothFur.setRotationPoint(0.0F, 1.8F, 0.0F);
        this.crothFur.addBox(-5.0F, 0.0F, -4.5F, 10, 18, 7, 0.0F);
        this.rToe01 = new RendererModel(this, 0, 116);
        this.rToe01.mirror = true;
        this.rToe01.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.rToe01.addBox(-0.5F, -0.9F, -4.5F, 1, 3, 5, 0.0F);
        this.setRotateAngle(rToe01, 0.17453292519943295F, 0.0F, 0.0F);
        this.rArm02.addChild(this.rArmFur);
        this.chest.addChild(this.rArm01);
        this.rPaw.addChild(this.rToe00);
        this.lArm02.addChild(this.lClaw02);
        this.chest.addChild(this.chestFur);
        this.neck01.addChild(this.head);
        this.rArm02.addChild(this.rClaw01);
        this.rLeg02.addChild(this.rLeg03);
        this.chest.addChild(this.lArm01);
        this.lArm02.addChild(this.lArmFur);
        this.hips.addChild(this.rLeg01);
        this.lArm02.addChild(this.lClaw00);
        this.lPaw.addChild(this.lToe00);
        this.lPaw.addChild(this.lToe01);
        this.lLeg03.addChild(this.lPaw);
        this.rLeg03.addChild(this.rPaw);
        this.stomach.addChild(this.hips);
        this.rLeg01.addChild(this.rLeg01Fur);
        this.chest.addChild(this.neck00);
        this.hips.addChild(this.lLeg01);
        this.neck00.addChild(this.neck01);
        this.rLeg02.addChild(this.rLeg02Fur);
        this.rLeg01.addChild(this.rLeg02);
        this.chest.addChild(this.chestFurLower);
        this.rLeg02.addChild(this.rLeg02FurMid);
        this.head.addChild(this.rEar);
        this.rArm02.addChild(this.rClaw02);
        this.lLeg02.addChild(this.lLeg02Fur);
        this.rArm01.addChild(this.rArm02);
        this.hips.addChild(this.tail00);
        this.tail00.addChild(this.tail01);
        this.head.addChild(this.lEar);
        this.chest.addChild(this.stomach);
        this.lLeg01.addChild(this.lLeg01Fur);
        this.lArm02.addChild(this.lClaw01);
        this.rPaw.addChild(this.rToe02);
        this.head.addChild(this.lowerJawOpen);
        this.lLeg02.addChild(this.lLeg03);
        this.lLeg02.addChild(this.lLeg02FurMid);
        this.rArm02.addChild(this.rClaw00);
        this.lPaw.addChild(this.lToe02);
        this.lArm01.addChild(this.lArm02);
        this.lLeg01.addChild(this.lLeg02);
        this.head.addChild(this.lowerJawClosed);
        this.hips.addChild(this.crothFur);
        this.rPaw.addChild(this.rToe01);
    }

    @Override
    public void render(EntityHidebehind entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.lowerJawOpen.showModel = entity.getOpen();
        GlStateManager.pushMatrix();
        {
            if(entity.getHiding() && f4 != 23) {
                GlStateManager.enableBlend();
                GlStateManager.enableAlphaTest();
                GlStateManager.color4f(1F, 1F, 1F, 0.5F);
                GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            }
            this.chest.render(f5);
            GlStateManager.disableAlphaTest();
            GlStateManager.disableBlend();
        }
        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(EntityHidebehind entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.lLeg01.rotateAngleX = (float) Math.cos(0.6F * limbSwing) * limbSwingAmount * 0.7F - 0.6108652381980153F;
        this.rLeg01.rotateAngleX = (float) Math.cos(0.6F * limbSwing + (float) Math.PI) * limbSwingAmount * 0.7F - 0.6108652381980153F;
        this.head.rotateAngleY = (float) Math.toRadians(netHeadYaw);
        this.head.rotateAngleX = (float) Math.toRadians(headPitch);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}
