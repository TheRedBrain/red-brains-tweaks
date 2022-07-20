package com.github.theredbrain.redbrainstweaks.registry;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import com.github.theredbrain.redbrainstweaks.block.*;
import com.github.theredbrain.redbrainstweaks.block.plants.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksRegistry {
    // work station blocks
    public static final NetheriteCauldronBlock NETHERITE_CAULDRON_BLOCK = new NetheriteCauldronBlock(FabricBlockSettings.of(Material.METAL, MapColor.STONE_GRAY).requiresTool().strength(2.0F).nonOpaque());
    public static final NetheriteLavaCauldronBlock NETHERITE_LAVA_CAULDRON_BLOCK = new NetheriteLavaCauldronBlock(FabricBlockSettings.copy(NETHERITE_CAULDRON_BLOCK).luminance((state) -> {
        return 15;
    }));
//    public static final StoveBlock STOVE = new StoveBlock(FabricBlockSettings.of(Material.METAL, MapColor.STONE_GRAY).requiresTool().strength(2.0F).nonOpaque());
    public static final CookingPotBlock COOKING_POT = new CookingPotBlock(FabricBlockSettings.of(Material.METAL).hardness(2.f).resistance(6.f).sounds(BlockSoundGroup.LANTERN));
    public static final BasketBlock BASKET = new BasketBlock(FabricBlockSettings.of(Material.WOOD).hardness(1.5f).resistance(1.5f).sounds(BlockSoundGroup.SCAFFOLDING).nonOpaque());
    public static final CuttingBoardBlock CUTTING_BOARD = new CuttingBoardBlock(FabricBlockSettings.of(Material.WOOD).hardness(2.f).resistance(2.f).sounds(BlockSoundGroup.WOOD));

    // inventory blocks
    public static final PantryBlock OAK_PANTRY = new PantryBlock(FabricBlockSettings.copyOf(Blocks.BARREL));
    public static final PantryBlock BIRCH_PANTRY = new PantryBlock(FabricBlockSettings.copyOf(Blocks.BARREL));
    public static final PantryBlock SPRUCE_PANTRY = new PantryBlock(FabricBlockSettings.copyOf(Blocks.BARREL));
    public static final PantryBlock JUNGLE_PANTRY = new PantryBlock(FabricBlockSettings.copyOf(Blocks.BARREL));
    public static final PantryBlock ACACIA_PANTRY = new PantryBlock(FabricBlockSettings.copyOf(Blocks.BARREL));
    public static final PantryBlock DARK_OAK_PANTRY = new PantryBlock(FabricBlockSettings.copyOf(Blocks.BARREL));
    public static final PantryBlock CRIMSON_PANTRY = new PantryBlock(FabricBlockSettings.copyOf(Blocks.BARREL));
    public static final PantryBlock WARPED_PANTRY = new PantryBlock(FabricBlockSettings.copyOf(Blocks.BARREL));

    // food blocks
    public static final PieBlock APPLE_PIE = new PieBlock(FabricBlockSettings.copyOf(Blocks.CAKE), ItemsRegistry.APPLE_PIE_SLICE);
    public static final PieBlock SWEET_BERRY_CHEESECAKE = new PieBlock(FabricBlockSettings.copyOf(Blocks.CAKE), ItemsRegistry.SWEET_BERRY_CHEESECAKE_SLICE);
    public static final PieBlock CHOCOLATE_PIE = new PieBlock(FabricBlockSettings.copyOf(Blocks.CAKE), ItemsRegistry.CHOCOLATE_PIE_SLICE);
    public static final PieBlock PUMPKIN_PIE = new PieBlock(FabricBlockSettings.copyOf(Blocks.CAKE), ItemsRegistry.PUMPKIN_PIE_SLICE);
    public static final RoastChickenBlock ROAST_CHICKEN_BLOCK = new RoastChickenBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL), ItemsRegistry.ROAST_CHICKEN, true);
    public static final FeastBlock STUFFED_PUMPKIN_BLOCK = new FeastBlock(FabricBlockSettings.copyOf(Blocks.PUMPKIN), ItemsRegistry.STUFFED_PUMPKIN, false);
    public static final HoneyGlazedHamBlock HONEY_GLAZED_HAM_BLOCK = new HoneyGlazedHamBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL), ItemsRegistry.HONEY_GLAZED_HAM, true);
    public static final ShepherdsPieBlock SHEPHERDS_PIE_BLOCK = new ShepherdsPieBlock(FabricBlockSettings.copyOf(Blocks.CAKE), ItemsRegistry.SHEPHERDS_PIE, true);

    // misc blocks
    public static final RopeBlock ROPE = new RopeBlock(FabricBlockSettings.of(Material.CARPET).noCollision().nonOpaque().hardness(.2f).resistance(.2f).sounds(BlockSoundGroup.WOOL));

    // storage blocks
    public static final PlacedToolBlock PLACED_TOOL_BLOCK = new PlacedToolBlock(FabricBlockSettings.of(Material.WOOD).noCollision().nonOpaque());
    public static final Block CARROT_CRATE =  new Block(FabricBlockSettings.of(Material.WOOD).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD));
    public static final Block POTATO_CRATE = new Block(FabricBlockSettings.of(Material.WOOD).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD));
    public static final Block BEETROOT_CRATE = new Block(FabricBlockSettings.of(Material.WOOD).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD));
    public static final Block CABBAGE_CRATE = new Block(FabricBlockSettings.of(Material.WOOD).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD));
    public static final Block TOMATO_CRATE = new Block(FabricBlockSettings.of(Material.WOOD).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD));
    public static final Block ONION_CRATE = new Block(FabricBlockSettings.of(Material.WOOD).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD));
    public static final Block RICE_BALE = new RiceBaleBlock(FabricBlockSettings.copyOf(Blocks.HAY_BLOCK));
    public static final Block RICE_BAG = new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL));
    public static final Block STRAW_BALE = new HayBlock(FabricBlockSettings.copyOf(Blocks.HAY_BLOCK));

    // soil blocks
    public static final Block GRASS_SLAB = new GrassSlabBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block DIRT_SLAB = new DirtSlabBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).ticksRandomly().strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final LooseDirtSlabBlock LOOSE_DIRT_SLAB = new LooseDirtSlabBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block COARSE_DIRT_SLAB = new SoilSlabBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block PODZOL_SLAB = new SoilSlabBlock(FabricBlockSettings.of(Material.SOIL, MapColor.SPRUCE_BROWN).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block MYCELIUM_SLAB = new MyceliumSlabBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.PURPLE).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block ROOTED_DIRT_SLAB = new SoilSlabBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.ROOTED_DIRT));
    public static final Block DIRT_PATH_SLAB = new DirtPathSlabBlock(FabricBlockSettings.of(Material.SOIL).strength(0.65F).sounds(BlockSoundGroup.GRASS).blockVision((state, world, pos) -> true).suffocates((state, world, pos) -> true));
    public static final Block SAND_SLAB = new FallingSlabBlock(14406560, FabricBlockSettings.of(Material.AGGREGATE, MapColor.PALE_YELLOW).strength(0.5F).sounds(BlockSoundGroup.SAND));
    public static final Block RED_SAND_SLAB = new FallingSlabBlock(11098145, FabricBlockSettings.of(Material.AGGREGATE, MapColor.ORANGE).strength(0.5F).sounds(BlockSoundGroup.SAND));
    public static final Block GRAVEL_SLAB = new FallingSlabBlock(-8356741, FabricBlockSettings.of(Material.AGGREGATE, MapColor.STONE_GRAY).strength(0.6F).sounds(BlockSoundGroup.GRAVEL));
    public static final OrganicCompostBlock ORGANIC_COMPOST = new OrganicCompostBlock(FabricBlockSettings.copyOf(Blocks.DIRT).hardness(1.2f).resistance(1.2f).sounds(BlockSoundGroup.CROP));
    public static final RichSoilBlock RICH_SOIL = new RichSoilBlock(FabricBlockSettings.copyOf(Blocks.DIRT).ticksRandomly().sounds(BlockSoundGroup.ROOTED_DIRT));
    public static final RichSoilFarmlandBlock RICH_SOIL_FARMLAND = new RichSoilFarmlandBlock(FabricBlockSettings.copyOf(Blocks.FARMLAND).sounds(BlockSoundGroup.ROOTED_DIRT));
    public static final LooseDirtBlock LOOSE_DIRT_BLOCK = new LooseDirtBlock(FabricBlockSettings.copyOf(Blocks.DIRT));
    public static final CustomFarmlandBlock CUSTOM_FARMLAND_BLOCK = new CustomFarmlandBlock(FabricBlockSettings.copyOf(Blocks.FARMLAND));

    // brick blocks
    public static final WetClayBrickBlock WET_CLAY_BRICK_BLOCK = new WetClayBrickBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.6F).sounds(BlockSoundGroup.GRAVEL));
    public static final IngotBlock BRICK_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.STONE, MapColor.RED).strength(2.0F, 6.0F).sounds(BlockSoundGroup.STONE));
    public static final IngotBlock NETHER_BRICK_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.STONE, MapColor.DARK_RED).strength(2.0F, 6.0F).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final IngotBlock DIAMOND_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.DIAMOND_BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final IngotBlock IRON_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final IngotBlock COPPER_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.ORANGE).strength(3.0F, 6.0F).sounds(BlockSoundGroup.COPPER));
    public static final IngotBlock GOLD_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.GOLD).strength(3.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final IngotBlock NETHERITE_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.BLACK).strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE));

    // plant blocks
    public static final CactusRootBlock CACTUS_ROOT_BLOCK = new CactusRootBlock(FabricBlockSettings.of(Material.CACTUS).requiresTool().ticksRandomly().strength(1.0F).sounds(BlockSoundGroup.WOOL));
    public static final SugarCaneRootBlock SUGAR_CANE_ROOT_BLOCK = new SugarCaneRootBlock(FabricBlockSettings.of(Material.PLANT).requiresTool().noCollision().ticksRandomly().strength(1.0F).sounds(BlockSoundGroup.GRASS));
    public static final MushroomColonyBlock BROWN_MUSHROOM_COLONY = new MushroomColonyBlock(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM), Items.BROWN_MUSHROOM);
    public static final MushroomColonyBlock RED_MUSHROOM_COLONY = new MushroomColonyBlock(FabricBlockSettings.copyOf(Blocks.RED_MUSHROOM), Items.RED_MUSHROOM);
    public static final WildPatchBlock WILD_CABBAGES = new WildPatchBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).sounds(BlockSoundGroup.CROP).offsetType(AbstractBlock.OffsetType.XZ));
    public static final WildPatchBlock WILD_ONIONS = new WildPatchBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).sounds(BlockSoundGroup.CROP).offsetType(AbstractBlock.OffsetType.NONE));
    public static final WildPatchBlock WILD_TOMATOES = new WildPatchBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).sounds(BlockSoundGroup.CROP).offsetType(AbstractBlock.OffsetType.XZ));
    public static final WildPatchBlock WILD_CARROTS = new WildPatchBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).sounds(BlockSoundGroup.CROP).offsetType(AbstractBlock.OffsetType.NONE));
    public static final WildPatchBlock WILD_POTATOES = new WildPatchBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).sounds(BlockSoundGroup.CROP).offsetType(AbstractBlock.OffsetType.XZ));
    public static final WildPatchBlock WILD_BEETROOTS = new WildPatchBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).sounds(BlockSoundGroup.CROP).offsetType(AbstractBlock.OffsetType.XZ));
    public static final WildRiceBlock WILD_RICE = new WildRiceBlock(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).sounds(BlockSoundGroup.WET_GRASS).offsetType(AbstractBlock.OffsetType.NONE));
    public static final CabbageCropBlock CABBAGE_CROP = new CabbageCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT));
    public static final OnionCropBlock ONION_CROP = new OnionCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT));
    public static final TomatoBushCropBlock TOMATO_CROP = new TomatoBushCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT));
    public static final RiceCropBlock RICE_CROP = new RiceCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT));
    public static final RiceUpperCropBlock RICE_UPPER_CROP = new RiceUpperCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT));
    public static final WeedBlock WEED_BLOCK = new WeedBlock(FabricBlockSettings.copyOf(Blocks.WHEAT).offsetType(AbstractBlock.OffsetType.NONE));
    public static final BeetrootsCropBlock CUSTOM_BEETROOTS_BLOCK = new BeetrootsCropBlock(FabricBlockSettings.copyOf(Blocks.BEETROOTS));
    public static final CarrotsCropBlock CUSTOM_CARROTS_BLOCK = new CarrotsCropBlock(FabricBlockSettings.copyOf(Blocks.CARROTS));
    public static final PotatoesCropBlock CUSTOM_POTATOES_BLOCK = new PotatoesCropBlock(FabricBlockSettings.copyOf(Blocks.POTATOES));
    public static final WheatCropBlock CUSTOM_WHEAT_BLOCK = new WheatCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT));
    public static final WheatUpperCropBlock WHEAT_UPPER_CROP = new WheatUpperCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT));

    // tree stump blocks
    public static final Block ACACIA_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block BIRCH_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block DARK_OAK_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block JUNGLE_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block OAK_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block SPRUCE_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));


    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "grass_slab"), GRASS_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "dirt_slab"), DIRT_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "loose_dirt_slab"), LOOSE_DIRT_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "coarse_dirt_slab"), COARSE_DIRT_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "podzol_slab"), PODZOL_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "mycelium_slab"), MYCELIUM_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "dirt_path_slab"), DIRT_PATH_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "rooted_dirt_slab"), ROOTED_DIRT_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "sand_slab"), SAND_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "red_sand_slab"), RED_SAND_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "gravel_slab"), GRAVEL_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "organic_compost"), ORGANIC_COMPOST);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "rich_soil"), RICH_SOIL);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "rich_soil_farmland"), RICH_SOIL_FARMLAND);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "loose_dirt"), LOOSE_DIRT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "custom_farmland"), CUSTOM_FARMLAND_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "cactus_root"), CACTUS_ROOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "sugar_cane_root"), SUGAR_CANE_ROOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "brown_mushroom_colony"), BROWN_MUSHROOM_COLONY);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "red_mushroom_colony"), RED_MUSHROOM_COLONY);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "wild_cabbages"), WILD_CABBAGES);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "wild_onions"), WILD_ONIONS);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "wild_tomatoes"), WILD_TOMATOES);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "wild_carrots"), WILD_CARROTS);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "wild_potatoes"), WILD_POTATOES);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "wild_beetroots"), WILD_BEETROOTS);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "wild_rice"), WILD_RICE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "cabbages"), CABBAGE_CROP);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "onions"), ONION_CROP);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "tomatoes"), TOMATO_CROP);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "rice_crop"), RICE_CROP);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "rice_upper_crop"), RICE_UPPER_CROP);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "weed_block"), WEED_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "custom_beetroots_block"), CUSTOM_BEETROOTS_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "custom_carrots_block"), CUSTOM_CARROTS_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "custom_potatoes_block"), CUSTOM_POTATOES_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "custom_wheat_block"), CUSTOM_WHEAT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "wheat_upper_crop"), WHEAT_UPPER_CROP);

        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "apple_pie"), APPLE_PIE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "sweet_berry_cheesecake"), SWEET_BERRY_CHEESECAKE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "chocolate_pie"), CHOCOLATE_PIE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "pumpkin_pie"), PUMPKIN_PIE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "roast_chicken_block"), ROAST_CHICKEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "stuffed_pumpkin_block"), STUFFED_PUMPKIN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "honey_glazed_ham_block"), HONEY_GLAZED_HAM_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "shepherds_pie_block"), SHEPHERDS_PIE_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "rope"), ROPE);

        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "placed_tool"), PLACED_TOOL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "carrot_crate"), CARROT_CRATE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "potato_crate"), POTATO_CRATE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "beetroot_crate"), BEETROOT_CRATE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "cabbage_crate"), CABBAGE_CRATE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "tomato_crate"), TOMATO_CRATE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "onion_crate"), ONION_CRATE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "rice_bale"), RICE_BALE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "rice_bag"), RICE_BAG);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "straw_bale"), STRAW_BALE);

        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "wet_clay_brick"), WET_CLAY_BRICK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "brick"), BRICK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "nether_brick"), NETHER_BRICK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "diamond_ingot"), DIAMOND_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "iron_ingot"), IRON_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "copper_ingot"), COPPER_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "gold_ingot"), GOLD_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "netherite_ingot"), NETHERITE_INGOT_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "netherite_cauldron"), NETHERITE_CAULDRON_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "netherite_lava_cauldron"), NETHERITE_LAVA_CAULDRON_BLOCK);
//        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "stove"), STOVE);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "cooking_pot"), COOKING_POT);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "basket"), BASKET);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "cutting_board"), CUTTING_BOARD);

        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "oak_pantry"), OAK_PANTRY);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "birch_pantry"), BIRCH_PANTRY);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "spruce_pantry"), SPRUCE_PANTRY);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "jungle_pantry"), JUNGLE_PANTRY);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "acacia_pantry"), ACACIA_PANTRY);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "dark_oak_pantry"), DARK_OAK_PANTRY);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "crimson_pantry"), CRIMSON_PANTRY);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "warped_pantry"), WARPED_PANTRY);

        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "acacia_stump"), ACACIA_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "birch_stump"), BIRCH_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "dark_oak_stump"), DARK_OAK_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "jungle_stump"), JUNGLE_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "oak_stump"), OAK_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(RedBrainsTweaks.MOD_ID, "spruce_stump"), SPRUCE_STUMP_BLOCK);
    }

    public static void registerFlammableBlocks() {
        FlammableBlockRegistry.getDefaultInstance().add(RICE_BALE, 20, 60);
        FlammableBlockRegistry.getDefaultInstance().add(STRAW_BALE, 20, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WILD_CABBAGES, 100, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WILD_ONIONS, 100, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WILD_TOMATOES, 100, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WILD_CARROTS, 100, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WILD_POTATOES, 100, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WILD_BEETROOTS, 100, 60);
        FlammableBlockRegistry.getDefaultInstance().add(WILD_RICE, 100, 60);
    }
}
