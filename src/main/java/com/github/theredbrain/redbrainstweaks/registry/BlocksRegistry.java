package com.github.theredbrain.redbrainstweaks.registry;

import com.github.theredbrain.redbrainstweaks.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlocksRegistry {
    // netherite cauldrons
    public static final NetheriteCauldronBlock NETHERITE_CAULDRON_BLOCK = new NetheriteCauldronBlock(FabricBlockSettings.of(Material.METAL, MapColor.STONE_GRAY).requiresTool().strength(2.0F).nonOpaque());
    public static final NetheriteLavaCauldronBlock NETHERITE_LAVA_CAULDRON_BLOCK = new NetheriteLavaCauldronBlock(FabricBlockSettings.copy(NETHERITE_CAULDRON_BLOCK).luminance((state) -> {
        return 15;
    }));

    // placed tool block
    public static final PlacedToolBlock PLACED_TOOL_BLOCK = new PlacedToolBlock(FabricBlockSettings.of(Material.WOOD).noCollision().nonOpaque());

    // soil slabs
    public static final Block GRASS_SLAB = new GrassSlabBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block DIRT_SLAB = new DirtSlabBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).ticksRandomly().strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block COARSE_DIRT_SLAB = new SoilSlabBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block PODZOL_SLAB = new SoilSlabBlock(FabricBlockSettings.of(Material.SOIL, MapColor.SPRUCE_BROWN).strength(0.5F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block MYCELIUM_SLAB = new MyceliumSlabBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.PURPLE).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS));
    public static final Block ROOTED_DIRT_SLAB = new SoilSlabBlock(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.ROOTED_DIRT));
    public static final Block DIRT_PATH_SLAB = new DirtPathSlabBlock(FabricBlockSettings.of(Material.SOIL).strength(0.65F).sounds(BlockSoundGroup.GRASS).blockVision((state, world, pos) -> {return true;}).suffocates((state, world, pos) -> {return true;}));
    public static final Block SAND_SLAB = new FallingSlabBlock(14406560, FabricBlockSettings.of(Material.AGGREGATE, MapColor.PALE_YELLOW).strength(0.5F).sounds(BlockSoundGroup.SAND));
    public static final Block RED_SAND_SLAB = new FallingSlabBlock(11098145, FabricBlockSettings.of(Material.AGGREGATE, MapColor.ORANGE).strength(0.5F).sounds(BlockSoundGroup.SAND));
    public static final Block GRAVEL_SLAB = new FallingSlabBlock(-8356741, FabricBlockSettings.of(Material.AGGREGATE, MapColor.STONE_GRAY).strength(0.6F).sounds(BlockSoundGroup.GRAVEL));

    // brick blocks
    public static final WetClayBrickBlock WET_CLAY_BRICK_BLOCK = new WetClayBrickBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.6F).sounds(BlockSoundGroup.GRAVEL));
    public static final IngotBlock BRICK_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.STONE, MapColor.RED).strength(2.0F, 6.0F).sounds(BlockSoundGroup.STONE));
    public static final IngotBlock NETHER_BRICK_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.STONE, MapColor.DARK_RED).strength(2.0F, 6.0F).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final IngotBlock DIAMOND_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.DIAMOND_BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final IngotBlock IRON_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final IngotBlock COPPER_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.ORANGE).strength(3.0F, 6.0F).sounds(BlockSoundGroup.COPPER));
    public static final IngotBlock GOLD_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.GOLD).strength(3.0F, 6.0F).sounds(BlockSoundGroup.METAL));
    public static final IngotBlock NETHERITE_INGOT_BLOCK = new IngotBlock(FabricBlockSettings.of(Material.METAL, MapColor.BLACK).strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE));


    // plant root blocks
    public static final CactusRootBlock CACTUS_ROOT_BLOCK = new CactusRootBlock(FabricBlockSettings.of(Material.CACTUS).requiresTool().ticksRandomly().strength(1.0F).sounds(BlockSoundGroup.WOOL));
    public static final SugarCaneRootBlock SUGAR_CANE_ROOT_BLOCK = new SugarCaneRootBlock(FabricBlockSettings.of(Material.PLANT).requiresTool().noCollision().ticksRandomly().strength(1.0F).sounds(BlockSoundGroup.GRASS));

    // tree stump blocks
    public static final Block ACACIA_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block BIRCH_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block DARK_OAK_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block JUNGLE_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block OAK_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block SPRUCE_STUMP_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).requiresTool().strength(50.0F, 6.0F).sounds(BlockSoundGroup.WOOD));


    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "grass_slab"), GRASS_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "dirt_slab"), DIRT_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "coarse_dirt_slab"), COARSE_DIRT_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "podzol_slab"), PODZOL_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "mycelium_slab"), MYCELIUM_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "dirt_path_slab"), DIRT_PATH_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "rooted_dirt_slab"), ROOTED_DIRT_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "sand_slab"), SAND_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "red_sand_slab"), RED_SAND_SLAB);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "gravel_slab"), GRAVEL_SLAB);

        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "cactus_root"), CACTUS_ROOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "sugar_cane_root"), SUGAR_CANE_ROOT_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "placed_tool"), PLACED_TOOL_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "wet_clay_brick"), WET_CLAY_BRICK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "brick"), BRICK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "nether_brick"), NETHER_BRICK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "diamond_ingot"), DIAMOND_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "iron_ingot"), IRON_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "copper_ingot"), COPPER_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "gold_ingot"), GOLD_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "netherite_ingot"), NETHERITE_INGOT_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "netherite_cauldron"), NETHERITE_CAULDRON_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "netherite_lava_cauldron"), NETHERITE_LAVA_CAULDRON_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "acacia_stump"), ACACIA_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "birch_stump"), BIRCH_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "dark_oak_stump"), DARK_OAK_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "jungle_stump"), JUNGLE_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "oak_stump"), OAK_STUMP_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("redbrainstweaks", "spruce_stump"), SPRUCE_STUMP_BLOCK);
    }
}
