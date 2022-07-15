package com.github.theredbrain.redBrainsTweaks;

import com.github.theredbrain.redBrainsTweaks.block.*;
import com.github.theredbrain.redBrainsTweaks.block.entity.PlacedToolEntity;
import com.github.theredbrain.redBrainsTweaks.entity.effect.*;
import com.github.theredbrain.redBrainsTweaks.item.FireStarterItem;
import com.github.theredbrain.redBrainsTweaks.item.NetheriteBucketItem;
import com.github.theredbrain.redBrainsTweaks.world.DarkOakStumpTreeDecorator;
import com.github.theredbrain.redBrainsTweaks.world.GiantStumpTreeDecorator;
import com.github.theredbrain.redBrainsTweaks.world.StumpTreeDecorator;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent.Builder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.*;
import net.minecraft.world.gen.trunk.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.OptionalInt;


public class RedBrainsTweaks implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("redbrainstweaks");

	// effects
	// low hunger bar
	public static final StatusEffect PECKISH = new PeckishStatusEffect();
	public static final StatusEffect HUNGRY = new HungryStatusEffect();
	public static final StatusEffect FAMISHED = new FamishedStatusEffect();
	public static final StatusEffect STARVING = new StarvingStatusEffect();
	public static final StatusEffect DYING = new DyingStatusEffect();

	// low health bar
	public static final StatusEffect HURT = new HurtStatusEffect();
	public static final StatusEffect INJURED = new InjuredStatusEffect();
	public static final StatusEffect WOUNDED = new WoundedStatusEffect();
	public static final StatusEffect CRIPPLED = new CrippledStatusEffect();
	public static final StatusEffect AGONIZING = new AgonizingStatusEffect();

	// high fat/saturation bar
	public static final StatusEffect PLUMP = new PlumpStatusEffect();
	public static final StatusEffect CHUBBY = new ChubbyStatusEffect();
	public static final StatusEffect FAT = new FatStatusEffect();
	public static final StatusEffect OBESE = new ObeseStatusEffect();

	// misc items
	public static final FireStarterItem FIRE_STARTER_ITEM = new FireStarterItem(new FabricItemSettings().maxCount(1).maxDamage(10).group(ItemGroup.TOOLS));
	public static final Item RAW_EGG_ITEM = new Item(new FabricItemSettings().maxCount(16).food(new Builder().hunger(1).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 1.0F).snack().alwaysEdible().build()).group(ItemGroup.FOOD));
	public static final Item CUT_GRASS_ITEM = new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.MISC));
//	public static final Item DIAMOND_INGOT_ITEM = new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.MATERIALS));

	// placed tool block
	public static final PlacedToolBlock PLACED_TOOL_BLOCK = new PlacedToolBlock(FabricBlockSettings.of(Material.WOOD).noCollision().nonOpaque());
	public static final BlockEntityType<PlacedToolEntity> PLACED_TOOL_ENTITY = FabricBlockEntityTypeBuilder.create(PlacedToolEntity::new, PLACED_TOOL_BLOCK).build(null);;

	// netherite buckets
	public static final NetheriteBucketItem NETHERITE_BUCKET_ITEM = new NetheriteBucketItem(Fluids.EMPTY, new FabricItemSettings().maxCount(16).group(ItemGroup.MISC).fireproof());
	public static final NetheriteBucketItem NETHERITE_LAVA_BUCKET_ITEM = new NetheriteBucketItem(Fluids.LAVA, new FabricItemSettings().recipeRemainder(NETHERITE_BUCKET_ITEM).maxCount(1).group(ItemGroup.MISC).fireproof());

	// netherite cauldrons
	public static final NetheriteCauldronBlock NETHERITE_CAULDRON_BLOCK = new NetheriteCauldronBlock(FabricBlockSettings.of(Material.METAL, MapColor.STONE_GRAY).requiresTool().strength(2.0F).nonOpaque());
	public static final NetheriteLavaCauldronBlock NETHERITE_LAVA_CAULDRON_BLOCK = new NetheriteLavaCauldronBlock(FabricBlockSettings.copy(NETHERITE_CAULDRON_BLOCK).luminance((state) -> {
		return 15;
	}));

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

	// tree decorators
	public static final TreeDecoratorType<StumpTreeDecorator> DARK_OAK_STUMP = new TreeDecoratorType(DarkOakStumpTreeDecorator.CODEC);
	public static final TreeDecoratorType<StumpTreeDecorator> GIANT_STUMP = new TreeDecoratorType(GiantStumpTreeDecorator.CODEC);
	public static final TreeDecoratorType<StumpTreeDecorator> STUMP = new TreeDecoratorType(StumpTreeDecorator.CODEC);

	// tag keys
	public static final TagKey<Biome> NO_PRECIPITATION = TagKey.of(Registry.BIOME_KEY, new Identifier("redbrainstweaks", "no_precipitation"));

	// custom trees
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_OAK = ConfiguredFeatures.register("custom_oak", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.OAK_LOG),
					new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.of(Blocks.OAK_LEAVES),
					new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
					new TwoLayersFeatureSize(1, 0, 1)))
			.decorators(List.of(new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.OAK_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_DARK_OAK = ConfiguredFeatures.register("custom_dark_oak", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.DARK_OAK_LOG),
					new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.of(Blocks.DARK_OAK_LEAVES),
					new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
					new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())))
			.ignoreVines()
			.decorators(List.of(new DarkOakStumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.DARK_OAK_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_BIRCH = ConfiguredFeatures.register("custom_birch", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.BIRCH_LOG),
					new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.of(Blocks.BIRCH_LEAVES),
					new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
					new TwoLayersFeatureSize(1, 0, 1)))
			.decorators(List.of(new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.BIRCH_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_ACACIA = ConfiguredFeatures.register("custom_acacia", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.ACACIA_LOG),
					new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.of(Blocks.ACACIA_LEAVES),
					new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
					new TwoLayersFeatureSize(1, 0, 2)))
			.ignoreVines()
			.decorators(List.of(
					new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.ACACIA_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_SPRUCE = ConfiguredFeatures.register("custom_spruce", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.SPRUCE_LOG),
					new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
					new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
					new TwoLayersFeatureSize(2, 0, 2))).ignoreVines()
			.decorators(List.of(
					new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.SPRUCE_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_FANCY_OAK = ConfiguredFeatures.register("custom_fancy_oak", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.OAK_LOG),
					new LargeOakTrunkPlacer(3, 11, 0), BlockStateProvider.of(Blocks.OAK_LEAVES),
					new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
					new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines()
			.decorators(List.of(
					new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.OAK_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_JUNGLE_TREE_NO_VINE = ConfiguredFeatures.register("custom_jungle_tree_no_vine", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.JUNGLE_LOG),
					new StraightTrunkPlacer(4, 8, 0), BlockStateProvider.of(Blocks.JUNGLE_LEAVES),
					new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
					new TwoLayersFeatureSize(1, 0, 1)))
			.ignoreVines()
			.decorators(List.of(
					new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.JUNGLE_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_MEGA_JUNGLE_TREE = ConfiguredFeatures.register("custom_mega_jungle_tree", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.JUNGLE_LOG),
					new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.of(Blocks.JUNGLE_LEAVES),
					new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
					new TwoLayersFeatureSize(1, 1, 2)))
			.decorators(ImmutableList.of(
					TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25F),
					new GiantStumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.JUNGLE_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_MEGA_SPRUCE = ConfiguredFeatures.register("custom_mega_spruce", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.SPRUCE_LOG),
					new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
					new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(13, 17)),
					new TwoLayersFeatureSize(1, 1, 2)))
			.decorators(ImmutableList.of(
					new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)),
					new GiantStumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.SPRUCE_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_MEGA_PINE = ConfiguredFeatures.register("custom_mega_pine", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.SPRUCE_LOG),
					new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
					new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(3, 7)),
					new TwoLayersFeatureSize(1, 1, 2)))
			.decorators(ImmutableList.of(
					new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)),
					new GiantStumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.SPRUCE_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_AZALEA_TREE = ConfiguredFeatures.register("custom_azalea_tree", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.OAK_LOG),
					new BendingTrunkPlacer(4, 2, 0, 3, UniformIntProvider.create(1, 2)),
					new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.AZALEA_LEAVES.getDefaultState(), 3).add(Blocks.FLOWERING_AZALEA_LEAVES.getDefaultState(), 1)),
					new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 50),
					new TwoLayersFeatureSize(1, 0, 1)))
			.decorators(List.of(
					new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.OAK_STUMP_BLOCK))))
			.dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_OAK_BEES_005 = ConfiguredFeatures.register("custom_oak_bees_005", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.OAK_LOG),
					new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.of(Blocks.OAK_LEAVES),
					new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
					new TwoLayersFeatureSize(1, 0, 1)))
			.decorators(List.of(
					new BeehiveTreeDecorator(0.05F),
					new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.OAK_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_BIRCH_BEES_005 = ConfiguredFeatures.register("custom_birch_bees_005", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.BIRCH_LOG),
					new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.of(Blocks.BIRCH_LEAVES),
					new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
					new TwoLayersFeatureSize(1, 0, 1)))
			.decorators(List.of(
					new BeehiveTreeDecorator(0.05F),
					new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.BIRCH_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_FANCY_OAK_BEES_005 = ConfiguredFeatures.register("custom_fancy_oak_bees_005", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.OAK_LOG),
					new LargeOakTrunkPlacer(3, 11, 0), BlockStateProvider.of(Blocks.OAK_LEAVES),
					new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
					new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))))
			.ignoreVines()
			.decorators(List.of(
					new BeehiveTreeDecorator(0.05F),
					new StumpTreeDecorator(BlockStateProvider.of(RedBrainsTweaks.OAK_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("TheRedBrain has tweaked the game!");
		registerBlocks();
		registerEffects();
		registerEntities();
		registerItems();
		registerMisc();
	}

	private void registerBlocks() {
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

	private void registerEffects() {
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "peckish"), PECKISH);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "hungry"), HUNGRY);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "famished"), FAMISHED);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "starving"), STARVING);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "dying"), DYING);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "hurt"), HURT);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "injured"), INJURED);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "wounded"), WOUNDED);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "crippled"), CRIPPLED);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "agonizing"), AGONIZING);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "plump"), PLUMP);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "chubby"), CHUBBY);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "fat"), FAT);
		Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "obese"), OBESE);
	}

	private void registerEntities() {
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("redbrainstweaks", "obese"), PLACED_TOOL_ENTITY);
	}

	private void registerItems() {
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "cut_grass"), CUT_GRASS_ITEM);
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "fire_starter"), FIRE_STARTER_ITEM);
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "raw_egg"), RAW_EGG_ITEM);
//		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "diamond_ingot"), DIAMOND_INGOT_ITEM);

		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "wet_clay_brick"), new BlockItem(WET_CLAY_BRICK_BLOCK, new FabricItemSettings().group(ItemGroup.MATERIALS)));
//		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "brick"), new BlockItem(BRICK_BLOCK, new FabricItemSettings().group(ItemGroup.MATERIALS)));
//		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "nether_brick"), new BlockItem(NETHER_BRICK_BLOCK, new FabricItemSettings().group(ItemGroup.MATERIALS)));
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "diamond_ingot"), new BlockItem(DIAMOND_INGOT_BLOCK, new FabricItemSettings().group(ItemGroup.MATERIALS)));

		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "netherite_bucket"), NETHERITE_BUCKET_ITEM);
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "netherite_lava_bucket"), NETHERITE_LAVA_BUCKET_ITEM);

		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "cactus_root"), new BlockItem(CACTUS_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "sugar_cane_root"), new BlockItem(SUGAR_CANE_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "netherite_cauldron"), new BlockItem(NETHERITE_CAULDRON_BLOCK, new FabricItemSettings().group(ItemGroup.BREWING).fireproof()));

		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "acacia_stump"), new BlockItem(ACACIA_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "birch_stump"), new BlockItem(BIRCH_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "dark_oak_stump"), new BlockItem(DARK_OAK_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "jungle_stump"), new BlockItem(JUNGLE_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "oak_stump"), new BlockItem(OAK_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "spruce_stump"), new BlockItem(SPRUCE_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
	}

	private void registerMisc() {
		Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier("redbrainstweaks", "dark_oak_stump"), DARK_OAK_STUMP);
		Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier("redbrainstweaks", "giant_stump"), GIANT_STUMP);
		Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier("redbrainstweaks", "stump"), STUMP);
	}
}
