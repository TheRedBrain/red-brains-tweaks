package com.github.theredbrain.redBrainsTweaks;

import com.github.theredbrain.redBrainsTweaks.block.CactusRootBlock;
import com.github.theredbrain.redBrainsTweaks.block.SugarCaneRootBlock;
import com.github.theredbrain.redBrainsTweaks.item.FireStarterItem;
import com.github.theredbrain.redBrainsTweaks.world.DarkOakStumpTreeDecorator;
import com.github.theredbrain.redBrainsTweaks.world.GiantStumpTreeDecorator;
import com.github.theredbrain.redBrainsTweaks.world.StumpTreeDecorator;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent.Builder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RedBrainsTweaks implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("red-brains-tweaks");

	// misc items
	public static final FireStarterItem FIRE_STARTER_ITEM = new FireStarterItem(new FabricItemSettings().maxCount(1).maxDamage(10).group(ItemGroup.TOOLS));
	public static final Item RAW_EGG = new Item(new FabricItemSettings().maxCount(16).food(new Builder().hunger(1).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 1.0F).snack().build()).group(ItemGroup.FOOD));
	public static final Item CUT_GRASS = new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.MISC));
	// TODO name wip
	public static final Item DIAMOND_INFUSED_IRON_INGOT = new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.MATERIALS));

	// misc blocks
	// TODO name wip
	public static final Block DIAMOND_INFUSED_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.DIAMOND_BLUE).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL));

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

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("TheRedBrain has tweaked the game!");
		registerBlocks();
		registerItems();
		registerMisc();
	}

	private void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "diamond_infused_iron_block"), DIAMOND_INFUSED_IRON_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "cactus_root"), CACTUS_ROOT_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "sugar_cane_root"), SUGAR_CANE_ROOT_BLOCK);

		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "acacia_stump"), ACACIA_STUMP_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "birch_stump"), BIRCH_STUMP_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "dark_oak_stump"), DARK_OAK_STUMP_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "jungle_stump"), JUNGLE_STUMP_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "oak_stump"), OAK_STUMP_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "spruce_stump"), SPRUCE_STUMP_BLOCK);
	}

	private void registerItems() {
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "cut_grass"), CUT_GRASS);
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "fire_starter"), FIRE_STARTER_ITEM);
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "raw_egg"), RAW_EGG);
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "diamond_infused_iron_ingot"), DIAMOND_INFUSED_IRON_INGOT);
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "diamond_infused_iron_block"), new BlockItem(DIAMOND_INFUSED_IRON_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "cactus_root"), new BlockItem(CACTUS_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "sugar_cane_root"), new BlockItem(SUGAR_CANE_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "acacia_stump"), new BlockItem(ACACIA_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "birch_stump"), new BlockItem(BIRCH_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "dark_oak_stump"), new BlockItem(DARK_OAK_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "jungle_stump"), new BlockItem(JUNGLE_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "oak_stump"), new BlockItem(OAK_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "spruce_stump"), new BlockItem(SPRUCE_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
	}

	private void registerMisc() {
		Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier("red-brains-tweaks", "dark_oak_stump"), DARK_OAK_STUMP);
		Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier("red-brains-tweaks", "giant_stump"), GIANT_STUMP);
		Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier("red-brains-tweaks", "stump"), STUMP);
	}
}
