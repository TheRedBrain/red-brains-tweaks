package com.github.theredbrain.redbrainstweaks.registry;

import com.github.theredbrain.redbrainstweaks.item.FireStarterItem;
import com.github.theredbrain.redbrainstweaks.item.NetheriteBucketItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsRegistry {

    // misc items
    public static final FireStarterItem FIRE_STARTER_ITEM = new FireStarterItem(new FabricItemSettings().maxCount(1).maxDamage(10).group(ItemGroup.TOOLS));
    public static final Item RAW_EGG_ITEM = new Item(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 1.0F).snack().alwaysEdible().build()).group(ItemGroup.FOOD));
    public static final Item CUT_GRASS_ITEM = new Item(new FabricItemSettings().maxCount(64).group(ItemGroup.MISC));

    // netherite buckets
    public static final NetheriteBucketItem NETHERITE_BUCKET_ITEM = new NetheriteBucketItem(Fluids.EMPTY, new FabricItemSettings().maxCount(16).group(ItemGroup.MISC).fireproof());
    public static final NetheriteBucketItem NETHERITE_LAVA_BUCKET_ITEM = new NetheriteBucketItem(Fluids.LAVA, new FabricItemSettings().recipeRemainder(NETHERITE_BUCKET_ITEM).maxCount(1).group(ItemGroup.MISC).fireproof());

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "grass_slab"), new BlockItem(BlocksRegistry.GRASS_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "dirt_slab"), new BlockItem(BlocksRegistry.DIRT_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "coarse_dirt_slab"), new BlockItem(BlocksRegistry.COARSE_DIRT_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "podzol_slab"), new BlockItem(BlocksRegistry.PODZOL_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "mycelium_slab"), new BlockItem(BlocksRegistry.MYCELIUM_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "rooted_dirt_slab"), new BlockItem(BlocksRegistry.ROOTED_DIRT_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "sand_slab"), new BlockItem(BlocksRegistry.SAND_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "red_sand_slab"), new BlockItem(BlocksRegistry.RED_SAND_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "gravel_slab"), new BlockItem(BlocksRegistry.GRAVEL_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "dirt_pile"), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "gravel_pile"), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "red_sand_pile"), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "sand_pile"), new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "cut_grass"), CUT_GRASS_ITEM);
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "fire_starter"), FIRE_STARTER_ITEM);
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "raw_egg"), RAW_EGG_ITEM);

        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "wet_clay_brick"), new BlockItem(BlocksRegistry.WET_CLAY_BRICK_BLOCK, new FabricItemSettings().group(ItemGroup.MATERIALS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "diamond_ingot"), new BlockItem(BlocksRegistry.DIAMOND_INGOT_BLOCK, new FabricItemSettings().group(ItemGroup.MATERIALS)));

        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "netherite_bucket"), NETHERITE_BUCKET_ITEM);
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "netherite_lava_bucket"), NETHERITE_LAVA_BUCKET_ITEM);

        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "cactus_root"), new BlockItem(BlocksRegistry.CACTUS_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "sugar_cane_root"), new BlockItem(BlocksRegistry.SUGAR_CANE_ROOT_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "netherite_cauldron"), new BlockItem(BlocksRegistry.NETHERITE_CAULDRON_BLOCK, new FabricItemSettings().group(ItemGroup.BREWING).fireproof()));

        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "acacia_stump"), new BlockItem(BlocksRegistry.ACACIA_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "birch_stump"), new BlockItem(BlocksRegistry.BIRCH_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "dark_oak_stump"), new BlockItem(BlocksRegistry.DARK_OAK_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "jungle_stump"), new BlockItem(BlocksRegistry.JUNGLE_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "oak_stump"), new BlockItem(BlocksRegistry.OAK_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier("redbrainstweaks", "spruce_stump"), new BlockItem(BlocksRegistry.SPRUCE_STUMP_BLOCK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
    }

}
