package com.github.theredbrain.redbrainstweaks.registry;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import com.github.theredbrain.redbrainstweaks.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsRegistry {

    // tools
    public static final FireStarterItem FIRE_STARTER_ITEM = new FireStarterItem(new FabricItemSettings().maxCount(1).maxDamage(10).group(ItemGroup.TOOLS));
    public static final KnifeItem FLINT_KNIFE = new KnifeItem(CustomToolMaterials.FLINT, .5F, -1.8F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final KnifeItem IRON_KNIFE = new KnifeItem(CustomToolMaterials.IRON, .5F, -1.8F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final KnifeItem GOLDEN_KNIFE = new KnifeItem(CustomToolMaterials.GOLD, .5F, -1.8F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final KnifeItem DIAMOND_KNIFE = new KnifeItem(CustomToolMaterials.DIAMOND, .5F, -1.8F, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final KnifeItem NETHERITE_KNIFE = new KnifeItem(CustomToolMaterials.NETHERITE, .5F, -1.8F, new FabricItemSettings().group(ItemGroup.TOOLS).fireproof());

    // forage foods
    public static final Item CABBAGE = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(Foods.CABBAGE));
    public static final Item HAM = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(Foods.HAM));
    public static final Item TOMATO = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(Foods.TOMATO));

    // basic food
    public static final Item BACON = new Item(new FabricItemSettings().food(Foods.BACON).group(ItemGroup.FOOD));
    public static final Item BEEF_PATTY = new Item(new FabricItemSettings().food(Foods.BEEF_PATTY).group(ItemGroup.FOOD));
    public static final Item CABBAGE_LEAF = new Item(new FabricItemSettings().food(Foods.CABBAGE_LEAF).group(ItemGroup.FOOD));
    public static final Item CHICKEN_CUTS = new Item(new FabricItemSettings().food(Foods.CHICKEN_CUTS).group(ItemGroup.FOOD));
    public static final Item COD_SLICE = new Item(new FabricItemSettings().food(Foods.COD_SLICE).group(ItemGroup.FOOD));
    public static final Item COOKED_BACON = new Item(new FabricItemSettings().food(Foods.COOKED_BACON).group(ItemGroup.FOOD));
    public static final Item COOKED_CHICKEN_CUTS = new Item(new FabricItemSettings().food(Foods.COOKED_CHICKEN_CUTS).group(ItemGroup.FOOD));
    public static final Item COOKED_COD_SLICE = new Item(new FabricItemSettings().food(Foods.COOKED_COD_SLICE).group(ItemGroup.FOOD));
    public static final Item COOKED_MUTTON_CHOPS = new Item(new FabricItemSettings().food(Foods.COOKED_MUTTON_CHOPS).group(ItemGroup.FOOD));
    public static final Item COOKED_SALMON_SLICE = new Item(new FabricItemSettings().food(Foods.COOKED_SALMON_SLICE).group(ItemGroup.FOOD));
    public static final Item FRIED_EGG = new Item(new FabricItemSettings().food(Foods.FRIED_EGG).group(ItemGroup.FOOD));
    public static final Item MINCED_BEEF = new Item(new FabricItemSettings().food(Foods.MINCED_BEEF).group(ItemGroup.FOOD));
    public static final Item MUTTON_CHOPS = new Item(new FabricItemSettings().food(Foods.MUTTON_CHOPS).group(ItemGroup.FOOD));
    public static final Item PIE_CRUST = new Item(new FabricItemSettings().food(Foods.PIE_CRUST).group(ItemGroup.FOOD));
    public static final Item PUMPKIN_SLICE = new Item(new FabricItemSettings().food(Foods.PUMPKIN_SLICE).group(ItemGroup.FOOD));
    public static final Item RAW_EGG_ITEM = new Item(new FabricItemSettings().food(Foods.RAW_EGG).group(ItemGroup.FOOD));
    public static final Item RAW_PASTA = new Item(new FabricItemSettings().food(Foods.RAW_PASTA).group(ItemGroup.FOOD));
    public static final Item SALMON_SLICE = new Item(new FabricItemSettings().food(Foods.SALMON_SLICE).group(ItemGroup.FOOD));
    public static final Item SMOKED_HAM = new Item(new FabricItemSettings().food(Foods.SMOKED_HAM).group(ItemGroup.FOOD));
    public static final ConsumableItem TOMATO_SAUCE = new ConsumableItem(new FabricItemSettings().food(Foods.TOMATO_SAUCE).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final Item WHEAT_DOUGH = new Item(new FabricItemSettings().food(Foods.WHEAT_DOUGH).group(ItemGroup.FOOD));

    //sweets
    public static final Item APPLE_PIE_SLICE = new Item(new FabricItemSettings().food(Foods.PIE_SLICE).group(ItemGroup.FOOD));
    public static final Item CAKE_SLICE = new Item(new FabricItemSettings().food(Foods.CAKE_SLICE).group(ItemGroup.FOOD));
    public static final Item CHOCOLATE_PIE_SLICE = new Item(new FabricItemSettings().food(Foods.CAKE_SLICE).group(ItemGroup.FOOD));
    public static final ConsumableItem FRUIT_SALAD = new ConsumableItem(new FabricItemSettings().food(Foods.FRUIT_SALAD).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final Item HONEY_COOKIE = new Item(new FabricItemSettings().food(FoodComponents.COOKIE).group(ItemGroup.FOOD));
    public static final Item MELON_POPSICLE = new Item(new FabricItemSettings().food(Foods.POPSICLE).group(ItemGroup.FOOD));
    public static final Item PUMPKIN_PIE_SLICE = new Item(new FabricItemSettings().food(Foods.PIE_SLICE).group(ItemGroup.FOOD));
    public static final Item SWEET_BERRY_CHEESECAKE_SLICE = new Item(new FabricItemSettings().food(Foods.CAKE_SLICE).group(ItemGroup.FOOD));
    public static final Item SWEET_BERRY_COOKIE = new Item(new FabricItemSettings().food(FoodComponents.COOKIE).group(ItemGroup.FOOD));

    // handheld foods
    public static final Item BACON_SANDWICH = new Item(new FabricItemSettings().food(Foods.BACON_SANDWICH).group(ItemGroup.FOOD));
    public static final Item BARBECUE_STICK = new Item(new FabricItemSettings().food(Foods.BARBECUE_STICK).group(ItemGroup.FOOD));
    public static final Item CABBAGE_ROLLS = new Item(new FabricItemSettings().food(Foods.CABBAGE_ROLLS).group(ItemGroup.FOOD));
    public static final Item CHICKEN_SANDWICH = new Item(new FabricItemSettings().food(Foods.CHICKEN_SANDWICH).group(ItemGroup.FOOD));
    public static final Item DUMPLINGS = new Item(new FabricItemSettings().food(Foods.DUMPLINGS).group(ItemGroup.FOOD));
    public static final Item EGG_SANDWICH = new Item(new FabricItemSettings().food(Foods.EGG_SANDWICH).group(ItemGroup.FOOD));
    public static final Item HAMBURGER = new Item(new FabricItemSettings().food(Foods.HAMBURGER).group(ItemGroup.FOOD));
    public static final ConsumableItem MIXED_SALAD = new ConsumableItem(new FabricItemSettings().food(Foods.MIXED_SALAD).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final Item MUTTON_WRAP = new Item(new FabricItemSettings().food(Foods.MUTTON_WRAP).group(ItemGroup.FOOD));
    public static final ConsumableItem NETHER_SALAD = new ConsumableItem(new FabricItemSettings().food(Foods.NETHER_SALAD).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final Item STUFFED_POTATO = new Item(new FabricItemSettings().food(Foods.STUFFED_POTATO).group(ItemGroup.FOOD));

    // bowl foods
    public static final ConsumableItem BAKED_COD_STEW = new ConsumableItem(new FabricItemSettings().food(Foods.BAKED_COD_STEW).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem BEEF_STEW = new ConsumableItem(new FabricItemSettings().food(Foods.BEEF_STEW).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem CHICKEN_SOUP = new ConsumableItem(new FabricItemSettings().food(Foods.CHICKEN_SOUP).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem COOKED_RICE = new ConsumableItem(new FabricItemSettings().food(Foods.COOKED_RICE).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem FISH_STEW = new ConsumableItem(new FabricItemSettings().food(Foods.FISH_STEW).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem FRIED_RICE = new ConsumableItem(new FabricItemSettings().food(Foods.FRIED_RICE).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem NOODLE_SOUP = new ConsumableItem(new FabricItemSettings().food(Foods.NOODLE_SOUP).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem PUMPKIN_SOUP = new ConsumableItem(new FabricItemSettings().food(Foods.PUMPKIN_SOUP).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem VEGETABLE_SOUP = new ConsumableItem(new FabricItemSettings().food(Foods.VEGETABLE_SOUP).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));

    // plated foods
    public static final ConsumableItem PASTA_WITH_MEATBALLS = new ConsumableItem(new FabricItemSettings().food(Foods.PASTA_WITH_MEATBALLS).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem PASTA_WITH_MUTTON_CHOP = new ConsumableItem(new FabricItemSettings().food(Foods.PASTA_WITH_MUTTON_CHOP).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem ROASTED_MUTTON_CHOPS = new ConsumableItem(new FabricItemSettings().food(Foods.ROASTED_MUTTON_CHOPS).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem VEGETABLE_NOODLES = new ConsumableItem(new FabricItemSettings().food(Foods.VEGETABLE_NOODLES).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem STEAK_AND_POTATOES = new ConsumableItem(new FabricItemSettings().food(Foods.STEAK_AND_POTATOES).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem RATATOUILLE = new ConsumableItem(new FabricItemSettings().food(Foods.RATATOUILLE).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem SQUID_INK_PASTA = new ConsumableItem(new FabricItemSettings().food(Foods.SQUID_INK_PASTA).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem GRILLED_SALMON = new ConsumableItem(new FabricItemSettings().food(Foods.GRILLED_SALMON).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem ROAST_CHICKEN = new ConsumableItem(new FabricItemSettings().food(Foods.ROAST_CHICKEN).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem STUFFED_PUMPKIN = new ConsumableItem(new FabricItemSettings().food(Foods.STUFFED_PUMPKIN).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem HONEY_GLAZED_HAM = new ConsumableItem(new FabricItemSettings().food(Foods.HONEY_GLAZED_HAM).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));
    public static final ConsumableItem SHEPHERDS_PIE = new ConsumableItem(new FabricItemSettings().food(Foods.SHEPHERDS_PIE).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.FOOD));

    // other foods
    public static final DogFoodItem DOG_FOOD = new DogFoodItem(new FabricItemSettings().food(Foods.DOG_FOOD).recipeRemainder(Items.BOWL).maxCount(16).group(ItemGroup.MISC));

    // misc items
    public static final Item CUT_GRASS_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item STRAW = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item CANVAS = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item TREE_BARK = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item RICE_PANICLE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final HorseFeedItem HORSE_FEED = new HorseFeedItem(new FabricItemSettings().maxCount(16).group(ItemGroup.MISC));
    public static final MilkBottleItem MILK_BOTTLE = new MilkBottleItem(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16).group(ItemGroup.FOOD));
    public static final HotCocoaItem HOT_COCOA = new HotCocoaItem(new FabricItemSettings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16).group(ItemGroup.FOOD));

    // netherite buckets
    public static final NetheriteBucketItem NETHERITE_BUCKET_ITEM = new NetheriteBucketItem(Fluids.EMPTY, new FabricItemSettings().maxCount(16).group(ItemGroup.MISC).fireproof());
    public static final NetheriteBucketItem NETHERITE_LAVA_BUCKET_ITEM = new NetheriteBucketItem(Fluids.LAVA, new FabricItemSettings().recipeRemainder(NETHERITE_BUCKET_ITEM).maxCount(1).group(ItemGroup.MISC).fireproof());
    
    public static void registerBlockItems() {
        // soil blocks
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "grass_slab"), new BlockItem(BlocksRegistry.GRASS_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "dirt_slab"), new BlockItem(BlocksRegistry.DIRT_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "loose_dirt_slab"), new BlockItem(BlocksRegistry.LOOSE_DIRT_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "coarse_dirt_slab"), new BlockItem(BlocksRegistry.COARSE_DIRT_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "podzol_slab"), new BlockItem(BlocksRegistry.PODZOL_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "mycelium_slab"), new BlockItem(BlocksRegistry.MYCELIUM_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "rooted_dirt_slab"), new BlockItem(BlocksRegistry.ROOTED_DIRT_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "sand_slab"), new BlockItem(BlocksRegistry.SAND_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "red_sand_slab"), new BlockItem(BlocksRegistry.RED_SAND_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "gravel_slab"), new BlockItem(BlocksRegistry.GRAVEL_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "organic_compost"), new BlockItem(BlocksRegistry.ORGANIC_COMPOST, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "rich_soil"), new BlockItem(BlocksRegistry.RICH_SOIL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "rich_soil_farmland"), new BlockItem(BlocksRegistry.RICH_SOIL_FARMLAND, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "loose_dirt"), new BlockItem(BlocksRegistry.LOOSE_DIRT_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        // storage blocks
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "wet_clay_brick"), new BlockItem(BlocksRegistry.WET_CLAY_BRICK_BLOCK, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "diamond_ingot"), new BlockItem(BlocksRegistry.DIAMOND_INGOT_BLOCK, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "carrot_crate"), new BlockItem(BlocksRegistry.CARROT_CRATE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "potato_crate"), new BlockItem(BlocksRegistry.POTATO_CRATE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "beetroot_crate"), new BlockItem(BlocksRegistry.BEETROOT_CRATE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cabbage_crate"), new BlockItem(BlocksRegistry.CABBAGE_CRATE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "tomato_crate"), new BlockItem(BlocksRegistry.TOMATO_CRATE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "onion_crate"), new BlockItem(BlocksRegistry.ONION_CRATE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "rice_bale"), new BlockItem(BlocksRegistry.RICE_BALE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "rice_bag"), new BlockItem(BlocksRegistry.RICE_BAG, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "straw_bale"), new BlockItem(BlocksRegistry.STRAW_BALE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        // plants
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cactus_root"), new BlockItem(BlocksRegistry.CACTUS_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "sugar_cane_root"), new BlockItem(BlocksRegistry.SUGAR_CANE_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "brown_mushroom_colony"), new MushroomColonyBlockItem(BlocksRegistry.BROWN_MUSHROOM_COLONY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "red_mushroom_colony"), new MushroomColonyBlockItem(BlocksRegistry.RED_MUSHROOM_COLONY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "wild_cabbages"), new BlockItem(BlocksRegistry.WILD_CABBAGES, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "wild_onions"), new BlockItem(BlocksRegistry.WILD_ONIONS, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "wild_tomatoes"), new BlockItem(BlocksRegistry.WILD_TOMATOES, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "wild_carrots"), new BlockItem(BlocksRegistry.WILD_CARROTS, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "wild_potatoes"), new BlockItem(BlocksRegistry.WILD_POTATOES, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "wild_beetroots"), new BlockItem(BlocksRegistry.WILD_BEETROOTS, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "wild_rice"), new BlockItem(BlocksRegistry.WILD_RICE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cabbage_seeds"), new AliasedBlockItem(BlocksRegistry.CABBAGE_CROP, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "rice"), new AliasedBlockItem(BlocksRegistry.RICE_CROP, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "tomato_seeds"), new AliasedBlockItem(BlocksRegistry.TOMATO_CROP, new FabricItemSettings().group(ItemGroup.MATERIALS)));

        // work stations
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "netherite_cauldron"), new BlockItem(BlocksRegistry.NETHERITE_CAULDRON_BLOCK, new FabricItemSettings().group(ItemGroup.BREWING).fireproof()));
//        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "stove"), new BlockItem(BlocksRegistry.STOVE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cooking_pot"), new BlockItem(BlocksRegistry.COOKING_POT, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cutting_board"), new BlockItem(BlocksRegistry.CUTTING_BOARD, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        // misc blocks
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "rope"), new RopeItem(new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        // inventory blocks
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "basket"), new BlockItem(BlocksRegistry.BASKET, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "oak_pantry"), new BlockItem(BlocksRegistry.OAK_PANTRY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "birch_pantry"), new BlockItem(BlocksRegistry.BIRCH_PANTRY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "spruce_pantry"), new BlockItem(BlocksRegistry.SPRUCE_PANTRY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "jungle_pantry"), new BlockItem(BlocksRegistry.JUNGLE_PANTRY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "acacia_pantry"), new BlockItem(BlocksRegistry.ACACIA_PANTRY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "dark_oak_pantry"), new BlockItem(BlocksRegistry.DARK_OAK_PANTRY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "crimson_pantry"), new BlockItem(BlocksRegistry.CRIMSON_PANTRY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "warped_pantry"), new BlockItem(BlocksRegistry.WARPED_PANTRY, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        // food blocks
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "apple_pie"), new BlockItem(BlocksRegistry.APPLE_PIE, new FabricItemSettings().group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "sweet_berry_cheesecake"), new BlockItem(BlocksRegistry.SWEET_BERRY_CHEESECAKE, new FabricItemSettings().group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "chocolate_pie"), new BlockItem(BlocksRegistry.CHOCOLATE_PIE, new FabricItemSettings().group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "pumpkin_pie"), new BlockItem(BlocksRegistry.PUMPKIN_PIE, new FabricItemSettings().group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "roast_chicken_block"), new BlockItem(BlocksRegistry.ROAST_CHICKEN_BLOCK, new FabricItemSettings().group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "stuffed_pumpkin_block"), new BlockItem(BlocksRegistry.STUFFED_PUMPKIN_BLOCK, new FabricItemSettings().group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "honey_glazed_ham_block"), new BlockItem(BlocksRegistry.HONEY_GLAZED_HAM_BLOCK, new FabricItemSettings().group(ItemGroup.FOOD)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "shepherds_pie_block"), new BlockItem(BlocksRegistry.SHEPHERDS_PIE_BLOCK, new FabricItemSettings().group(ItemGroup.FOOD)));

        // stumps
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "acacia_stump"), new BlockItem(BlocksRegistry.ACACIA_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "birch_stump"), new BlockItem(BlocksRegistry.BIRCH_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "dark_oak_stump"), new BlockItem(BlocksRegistry.DARK_OAK_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "jungle_stump"), new BlockItem(BlocksRegistry.JUNGLE_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "oak_stump"), new BlockItem(BlocksRegistry.OAK_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "spruce_stump"), new BlockItem(BlocksRegistry.SPRUCE_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
    }
    
    public static void registerItems() {
        // soil items
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "dirt_pile"), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "gravel_pile"), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "red_sand_pile"), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "sand_pile"), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

        // tool items
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "fire_starter"), FIRE_STARTER_ITEM);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "flint_knife"), FLINT_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "iron_knife"), IRON_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "golden_knife"), GOLDEN_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "diamond_knife"), DIAMOND_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "netherite_knife"), NETHERITE_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "netherite_bucket"), NETHERITE_BUCKET_ITEM);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "netherite_lava_bucket"), NETHERITE_LAVA_BUCKET_ITEM);

        // misc items
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cut_grass"), CUT_GRASS_ITEM);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "straw"), STRAW);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "canvas"), CANVAS);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "tree_bark"), TREE_BARK);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "rice_panicle"), RICE_PANICLE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "horse_feed"), HORSE_FEED);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "milk_bottle"), MILK_BOTTLE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "hot_cocoa"), HOT_COCOA);

        // forage foods
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cabbage"), CABBAGE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "ham"), HAM);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "onion"), new AliasedBlockItem(BlocksRegistry.ONION_CROP, new FabricItemSettings().food(Foods.ONION).group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "tomato"), TOMATO);

        // basic foods
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "bacon"), BACON);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "beef_patty"), BEEF_PATTY);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cabbage_leaf"), CABBAGE_LEAF);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "chicken_cuts"), CHICKEN_CUTS);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cod_slice"), COD_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cooked_bacon"), COOKED_BACON);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cooked_chicken_cuts"), COOKED_CHICKEN_CUTS);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cooked_cod_slice"), COOKED_COD_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cooked_mutton_chops"), COOKED_MUTTON_CHOPS);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cooked_salmon_slice"), COOKED_SALMON_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "fried_egg"), FRIED_EGG);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "minced_beef"), MINCED_BEEF);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "mutton_chops"), MUTTON_CHOPS);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "pie_crust"), PIE_CRUST);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "pumpkin_slice"), PUMPKIN_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "raw_egg"), RAW_EGG_ITEM);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "raw_pasta"), RAW_PASTA);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "salmon_slice"), SALMON_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "smoked_ham"), SMOKED_HAM);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "tomato_sauce"), TOMATO_SAUCE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "wheat_dough"), WHEAT_DOUGH);

        // sweets
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "apple_pie_slice"), APPLE_PIE_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cake_slice"), CAKE_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "chocolate_pie_slice"), CHOCOLATE_PIE_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "fruit_salad"), FRUIT_SALAD);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "honey_cookie"), HONEY_COOKIE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "melon_popsicle"), MELON_POPSICLE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "pumpkin_pie_slice"), PUMPKIN_PIE_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "sweet_berry_cheesecake_slice"), SWEET_BERRY_CHEESECAKE_SLICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "sweet_berry_cookie"), SWEET_BERRY_COOKIE);

        // handheld foods
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "bacon_sandwich"), BACON_SANDWICH);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "barbecue_stick"), BARBECUE_STICK);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cabbage_rolls"), CABBAGE_ROLLS);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "chicken_sandwich"), CHICKEN_SANDWICH);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "dumplings"), DUMPLINGS);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "egg_sandwich"), EGG_SANDWICH);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "hamburger"), HAMBURGER);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "mixed_salad"), MIXED_SALAD);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "mutton_wrap"), MUTTON_WRAP);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "nether_salad"), NETHER_SALAD);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "stuffed_potato"), STUFFED_POTATO);

        // bowl foods
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "baked_cod_stew"), BAKED_COD_STEW);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "beef_stew"), BEEF_STEW);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "chicken_soup"), CHICKEN_SOUP);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "cooked_rice"), COOKED_RICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "fish_stew"), FISH_STEW);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "fried_rice"), FRIED_RICE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "noodle_soup"), NOODLE_SOUP);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "pumpkin_soup"), PUMPKIN_SOUP);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "vegetable_soup"), VEGETABLE_SOUP);

        // plated foods
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "pasta_with_meatballs"), PASTA_WITH_MEATBALLS);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "pasta_with_mutton_chop"), PASTA_WITH_MUTTON_CHOP);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "roasted_mutton_chops"), ROASTED_MUTTON_CHOPS);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "vegetable_noodles"), VEGETABLE_NOODLES);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "steak_and_potatoes"), STEAK_AND_POTATOES);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "ratatouille"), RATATOUILLE);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "squid_ink_pasta"), SQUID_INK_PASTA);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "grilled_salmon"), GRILLED_SALMON);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "roast_chicken"), ROAST_CHICKEN);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "stuffed_pumpkin"), STUFFED_PUMPKIN);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "honey_glazed_ham"), HONEY_GLAZED_HAM);
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "shepherds_pie"), SHEPHERDS_PIE);

        // other foods
        Registry.register(Registry.ITEM, new Identifier(RedBrainsTweaks.MOD_ID, "dog_food"), DOG_FOOD);
    }

    // TODO balance fuel times
    public static void registerFuelTimes() {
        FuelRegistry.INSTANCE.add(BlocksRegistry.OAK_PANTRY, 300);
        FuelRegistry.INSTANCE.add(BlocksRegistry.BIRCH_PANTRY, 300);
        FuelRegistry.INSTANCE.add(BlocksRegistry.SPRUCE_PANTRY, 300);
        FuelRegistry.INSTANCE.add(BlocksRegistry.JUNGLE_PANTRY, 300);
        FuelRegistry.INSTANCE.add(BlocksRegistry.ACACIA_PANTRY, 300);
        FuelRegistry.INSTANCE.add(BlocksRegistry.DARK_OAK_PANTRY, 300);

        FuelRegistry.INSTANCE.add(BlocksRegistry.ROPE, 200);
        
        FuelRegistry.INSTANCE.add(STRAW, 100);
        FuelRegistry.INSTANCE.add(CANVAS, 400);
        FuelRegistry.INSTANCE.add(TREE_BARK, 200);
        
        
    }
}
