package com.github.theredbrain.redBrainsTweaks;

import com.github.theredbrain.redBrainsTweaks.block.CactusRootBlock;
import com.github.theredbrain.redBrainsTweaks.block.SugarCaneRootBlock;
import com.github.theredbrain.redBrainsTweaks.item.FireStarterItem;
import com.github.theredbrain.redBrainsTweaks.mixin.block.SugarCaneBlockMixin;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RedBrainsTweaks implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("red-brains-tweaks");
	public static final FireStarterItem FIRE_STARTER_ITEM = new FireStarterItem(new FabricItemSettings().maxCount(1).maxDamage(10).group(ItemGroup.TOOLS));
	public static final Item RAW_EGG = new Item(new FabricItemSettings().maxCount(16).food(new Builder().hunger(1).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 1.0F).snack().build()).group(ItemGroup.FOOD));
	public static final Item CUT_GRASS = new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.MISC));
	public static final CactusRootBlock CACTUS_ROOT_BLOCK = new CactusRootBlock(FabricBlockSettings.of(Material.CACTUS).requiresTool().ticksRandomly().strength(1.0F).sounds(BlockSoundGroup.WOOL));
	public static final SugarCaneRootBlock SUGAR_CANE_ROOT_BLOCK = new SugarCaneRootBlock(FabricBlockSettings.of(Material.PLANT).requiresTool().noCollision().ticksRandomly().strength(1.0F).sounds(BlockSoundGroup.GRASS));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("TheRedBrain has tweaked the game!");
		registerBlocks();
		registerItems();
	}

	private void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "cactus_root"), CACTUS_ROOT_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("red-brains-tweaks", "sugar_cane_root"), SUGAR_CANE_ROOT_BLOCK);
	}

	private void registerItems() {
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "cut_grass"), CUT_GRASS);
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "fire_starter"), FIRE_STARTER_ITEM);
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "raw_egg"), RAW_EGG);
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "cactus_root"), new BlockItem(CACTUS_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("red-brains-tweaks", "sugar_cane_root"), new BlockItem(SUGAR_CANE_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
	}
}
