package com.Killer.killersblocksnstuff.core.init;

import com.Killer.killersblocksnstuff.KillersBlocksNStuff;
import com.Killer.killersblocksnstuff.core.init.*;
import com.Killer.killersblocksnstuff.util.enums.KbnsArmorMaterial;
import com.Killer.killersblocksnstuff.util.enums.KbnsItemTier;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> VIBRANIUM_POWDER;
    public static final RegistryObject<Item> VIBRANIUM_INGOT;
    public static final RegistryObject<Item> REINFORCED_TOOL_ROD;
    public static final RegistryObject<Item> VOID_STONE_POWDER;
    public static final RegistryObject<Item> REFINED_VIBRANIUM_POWDER;
    public static final RegistryObject<Item> VIBRANIUM_ORE_ITEM;
    public static final RegistryObject<Item> VIBRANIUM_BLOCK_ITEM;
    public static final RegistryObject<Item> REFINED_VIBRANIUM_POWDER_BLOCK_ITEM;
    public static final RegistryObject<Item> VOID_STONE_ITEM;
    public static final RegistryObject<Item> CONCRETE_LAMP_WHITE_ITEM;
    public static final RegistryObject<Item> CONCRETE_LAMP_ORANGE_ITEM;
    public static final RegistryObject<Item> CONCRETE_LAMP_RED_ITEM;
    public static final RegistryObject<Item> VIBRANIUM_SWORD;
    public static final RegistryObject<Item> VIBRANIUM_PICKAXE;
    public static final RegistryObject<Item> VIBRANIUM_AXE;
    public static final RegistryObject<Item> VIBRANIUM_SHOVEL;
    public static final RegistryObject<Item> VIBRANIUM_HOE;
    public static final RegistryObject<Item> VIBRANIUM_HELMET;
    public static final RegistryObject<Item> VIBRANIUM_CHESTPLATE;
    public static final RegistryObject<Item> VIBRANIUM_LEGGINGS;
    public static final RegistryObject<Item> VIBRANIUM_BOOTS;

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "kbns");
        VIBRANIUM_POWDER = ITEMS.register("vibranium_powder", ItemBase::new);
        VIBRANIUM_INGOT = ITEMS.register("vibranium_ingot", ItemBase::new);
        REINFORCED_TOOL_ROD = ITEMS.register("reinforced_tool_rod", ItemBase::new);
        VOID_STONE_POWDER = ITEMS.register("void_stone_powder", ItemBase::new);
        REFINED_VIBRANIUM_POWDER = ITEMS.register("refined_vibranium_powder", ItemBase::new);
        VIBRANIUM_ORE_ITEM = ITEMS.register("vibranium_ore", () -> {
           return new BlockItemBase((Block)BlockInit.VIBRANIUM_ORE.get());
        });
        VIBRANIUM_BLOCK_ITEM = ITEMS.register("vibranium_block", () -> {
            return new BlockItemBase((Block)BlockInit.VIBRANIUM_BLOCK.get());
        });
        REFINED_VIBRANIUM_POWDER_BLOCK_ITEM = ITEMS.register("refined_vibranium_powder_block", () -> {
            return new BlockItemBase((Block)BlockInit.REFINED_VIBRANIUM_POWDER_BLOCK.get());
        });
        VOID_STONE_ITEM = ITEMS.register("void_stone", () -> {
            return new BlockItemBase((Block)BlockInit.VOID_STONE.get());
        });
        CONCRETE_LAMP_WHITE_ITEM = ITEMS.register("concrete_lamp_white", () -> {
            return new BlockItemBase((Block)BlockInit.CONCRETE_LAMP_WHITE.get());
        });
        CONCRETE_LAMP_ORANGE_ITEM = ITEMS.register("concrete_lamp_orange", () -> {
            return new BlockItemBase((Block)BlockInit.CONCRETE_LAMP_ORANGE.get());
        });
        CONCRETE_LAMP_RED_ITEM = ITEMS.register("concrete_lamp_red", () -> {
            return new BlockItemBase((Block)BlockInit.CONCRETE_LAMP_RED.get());
        });
        VIBRANIUM_SWORD = ITEMS.register("vibranium_sword", () -> {
            return new SwordItem(KbnsItemTier.VIBRANIUM, 1, -2.2F, (new Properties()).tab(KillersBlocksNStuff.KBNS_TAB));
        });
        VIBRANIUM_PICKAXE = ITEMS.register("vibranium_pickaxe", () -> {
            return new PickaxeItem(KbnsItemTier.VIBRANIUM, -2, -2.2F, (new Properties()).tab(KillersBlocksNStuff.KBNS_TAB));
        });
        VIBRANIUM_AXE = ITEMS.register("vibranium_axe", () -> {
            return new AxeItem(KbnsItemTier.VIBRANIUM, 2.0F, -2.9F, (new Properties()).tab(KillersBlocksNStuff.KBNS_TAB));
        });
        VIBRANIUM_SHOVEL = ITEMS.register("vibranium_shovel", () -> {
            return new ShovelItem(KbnsItemTier.VIBRANIUM, -3.0F, -2.4F, (new Properties()).tab(KillersBlocksNStuff.KBNS_TAB));
        });
        VIBRANIUM_HOE = ITEMS.register("vibranium_hoe", () -> {
            return new HoeItem(KbnsItemTier.VIBRANIUM, -3, -2.6F, (new Properties()).tab(KillersBlocksNStuff.KBNS_TAB));
        });
        VIBRANIUM_HELMET = ITEMS.register("vibranium_helmet", () -> {
            return new ArmorItem(KbnsArmorMaterial.VIBRANIUM, EquipmentSlotType.HEAD, (new Properties()).tab(KillersBlocksNStuff.KBNS_TAB));
        });
        VIBRANIUM_CHESTPLATE = ITEMS.register("vibranium_chestplate", () -> {
            return new ArmorItem(KbnsArmorMaterial.VIBRANIUM, EquipmentSlotType.CHEST, (new Properties()).tab(KillersBlocksNStuff.KBNS_TAB));
        });
        VIBRANIUM_LEGGINGS = ITEMS.register("vibranium_leggings", () -> {
            return new ArmorItem(KbnsArmorMaterial.VIBRANIUM, EquipmentSlotType.LEGS, (new Properties()).tab(KillersBlocksNStuff.KBNS_TAB));
        });
        VIBRANIUM_BOOTS = ITEMS.register("vibranium_boots", () -> {
            return new ArmorItem(KbnsArmorMaterial.VIBRANIUM, EquipmentSlotType.FEET, (new Properties()).tab(KillersBlocksNStuff.KBNS_TAB));
        });
    }
}

