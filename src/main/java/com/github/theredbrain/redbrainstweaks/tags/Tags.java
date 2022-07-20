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
    public static final TagKey<Block> FARM_LAND = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "farm_land"));
    public static final TagKey<Block> FARM_LAND_PLANTER = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "farm_land_planter"));
    public static final TagKey<Block> FERTILIZABLE_FARM_LAND = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "fertilizable_farm_land"));
    public static final TagKey<Block> NON_FERTILIZABLE_FARM_LAND = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "non_fertilizable_farm_land"));
    public static final TagKey<Block> NO_WEED_FARM_LAND = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "no_weed_farm_land"));
    public static final TagKey<Block> HEAT_SOURCES = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "heat_sources"));
    public static final TagKey<Block> TRAY_HEAT_SOURCES = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "tray_heat_sources"));
    public static final TagKey<Block> COMPOST_ACTIVATORS = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "compost_activators"));
    public static final TagKey<Block> UNAFFECTED_BY_RICH_SOIL = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "unaffected_by_rich_soil"));
    public static final TagKey<Block> KNIVES_CUTTABLE = TagKey.of(Registry.BLOCK_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "knives_cuttable"));
    public static final TagKey<Item> WILD_CROPS_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "wild_crops"));
    public static final TagKey<Item> STRAW_HARVESTERS = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "straw_harvesters"));
    public static final TagKey<Item> WOLF_PREY = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "wolf_prey"));
    public static final TagKey<Item> CABBAGE_ROLL_INGREDIENTS = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "tools/knives"));
    public static final TagKey<Item> FERTILIZERS = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "fertilizers"));
    public static final TagKey<Item> HOES = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "tools/hoes"));
    public static final TagKey<Item> WEEDING_HOES = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "tools/weeding_hoes"));
    public static final TagKey<Item> KNIVES = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "tools/knives"));
    public static final TagKey<Item> PROPER_DIGGING_TOOLS = TagKey.of(Registry.ITEM_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "tools/proper_digging_tools"));
    public static final TagKey<EntityType<?>> DOG_FOOD_USERS = TagKey.of(Registry.ENTITY_TYPE_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "dog_food_users"));
    public static final TagKey<EntityType<?>> HORSE_FEED_USERS = TagKey.of(Registry.ENTITY_TYPE_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "horse_feed_users"));
    public static final TagKey<EntityType<?>> STARTS_PATROLS_WHEN_KILLED = TagKey.of(Registry.ENTITY_TYPE_KEY, new Identifier(RedBrainsTweaks.MOD_ID, "starts_patrols_when_killed"));
}
