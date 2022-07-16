package com.github.theredbrain.redbrainstweaks.tags;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class Tags {

    public static final TagKey<Block> WILD_CROPS = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "wild_crops"));
    public static final TagKey<Block> HEAT_SOURCES = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "heat_sources"));
    public static final TagKey<Block> TRAY_HEAT_SOURCES = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "tray_heat_sources"));
    public static final TagKey<Block> COMPOST_ACTIVATORS = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "compost_activators"));
    public static final TagKey<Block> UNAFFECTED_BY_RICH_SOIL = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "unaffected_by_rich_soil"));
    public static final TagKey<Block> KNIVES_CUTTABLE = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "knives_cuttable"));
    public static final TagKey<Item> WILD_CROPS_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "wild_crops"));
    public static final TagKey<Item> STRAW_HARVESTERS = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "straw_harvesters"));
    public static final TagKey<Item> WOLF_PREY = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "wolf_prey"));
    public static final TagKey<Item> CABBAGE_ROLL_INGREDIENTS = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "tools/knives"));
    public static final TagKey<Item> KNIVES = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "tools/knives"));
    public static final TagKey<EntityType<?>> DOG_FOOD_USERS = TagKey.of(Registry.ENTITY_TYPE_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "dog_food_users"));
    public static final TagKey<EntityType<?>> HORSE_FEED_USERS = TagKey.of(Registry.ENTITY_TYPE_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "horse_feed_users"));
}
