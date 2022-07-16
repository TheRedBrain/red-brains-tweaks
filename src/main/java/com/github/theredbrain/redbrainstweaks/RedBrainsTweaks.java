package com.github.theredbrain.redbrainstweaks;

import com.github.theredbrain.redbrainstweaks.registry.*;
import com.github.theredbrain.redbrainstweaks.world.DarkOakStumpTreeDecorator;
import com.github.theredbrain.redbrainstweaks.world.GiantStumpTreeDecorator;
import com.github.theredbrain.redbrainstweaks.world.StumpTreeDecorator;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.ModInitializer;

import net.minecraft.block.*;
import net.minecraft.tag.TagKey;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
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
	public static final String MOD_ID = "redbrainstweaks";

	public static MutableText i18n(String key, Object... args) {
		return Text.translatable(MOD_ID + "." + key, args);
	}

	// tree decorators
	public static final TreeDecoratorType<StumpTreeDecorator> DARK_OAK_STUMP = new TreeDecoratorType(DarkOakStumpTreeDecorator.CODEC);
	public static final TreeDecoratorType<StumpTreeDecorator> GIANT_STUMP = new TreeDecoratorType(GiantStumpTreeDecorator.CODEC);
	public static final TreeDecoratorType<StumpTreeDecorator> STUMP = new TreeDecoratorType(StumpTreeDecorator.CODEC);

	// tag keys
	public static final TagKey<Biome> NO_PRECIPITATION = TagKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "no_precipitation"));

	// custom trees
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_OAK = ConfiguredFeatures.register("custom_oak", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.OAK_LOG),
					new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.of(Blocks.OAK_LEAVES),
					new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
					new TwoLayersFeatureSize(1, 0, 1)))
			.decorators(List.of(new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.OAK_STUMP_BLOCK))))
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
			.decorators(List.of(new DarkOakStumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.DARK_OAK_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());
	public static final RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> CUSTOM_BIRCH = ConfiguredFeatures.register("custom_birch", Feature.TREE, (
			new TreeFeatureConfig.Builder(
					BlockStateProvider.of(Blocks.BIRCH_LOG),
					new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.of(Blocks.BIRCH_LEAVES),
					new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
					new TwoLayersFeatureSize(1, 0, 1)))
			.decorators(List.of(new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.BIRCH_STUMP_BLOCK))))
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
					new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.ACACIA_STUMP_BLOCK))))
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
					new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.SPRUCE_STUMP_BLOCK))))
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
					new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.OAK_STUMP_BLOCK))))
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
					new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.JUNGLE_STUMP_BLOCK))))
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
					new GiantStumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.JUNGLE_STUMP_BLOCK))))
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
					new GiantStumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.SPRUCE_STUMP_BLOCK))))
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
					new GiantStumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.SPRUCE_STUMP_BLOCK))))
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
					new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.OAK_STUMP_BLOCK))))
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
					new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.OAK_STUMP_BLOCK))))
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
					new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.BIRCH_STUMP_BLOCK))))
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
					new StumpTreeDecorator(BlockStateProvider.of(BlocksRegistry.OAK_STUMP_BLOCK))))
			.dirtProvider(new WeightedBlockStateProvider(new DataPool.Builder().add(Blocks.DIRT.getDefaultState(), 3).add(Blocks.ROOTED_DIRT.getDefaultState(), 1)))
			.forceDirt()
			.build());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("TheRedBrain has tweaked the game!");
		AdvancementsRegistry.registerAll();
		BlocksRegistry.registerBlocks();
		BlocksRegistry.registerFlammableBlocks();
		EnchantmentsRegistry.registerAll();
		EntitiesRegistry.registerBlockEntities();
		ExtendedScreenTypesRegistry.registerAll();
		ItemsRegistry.registerBlockItems();
		ItemsRegistry.registerItems();
		ItemsRegistry.registerFuelTimes();
		LootFunctionsRegistry.registerAll();
		ParticleTypesRegistry.registerAll();
		RecipeTypesRegistry.registerAll();
		registerMisc();
		SoundsRegistry.registerAll();
		StatusEffectsRegistry.registerEffects();
	}

	private void registerMisc() {
		Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier("redbrainstweaks", "dark_oak_stump"), DARK_OAK_STUMP);
		Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier("redbrainstweaks", "giant_stump"), GIANT_STUMP);
		Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier("redbrainstweaks", "stump"), STUMP);
	}
}
