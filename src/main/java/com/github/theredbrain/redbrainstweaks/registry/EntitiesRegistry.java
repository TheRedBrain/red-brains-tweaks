package com.github.theredbrain.redbrainstweaks.registry;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import com.github.theredbrain.redbrainstweaks.block.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntitiesRegistry {
    public static final BlockEntityType<PlacedToolEntity> PLACED_TOOL_ENTITY = FabricBlockEntityTypeBuilder.create(PlacedToolEntity::new, BlocksRegistry.PLACED_TOOL_BLOCK).build(null);
//    public static final BlockEntityType<StoveBlockEntity> STOVE_ENTITY = FabricBlockEntityTypeBuilder.create(StoveBlockEntity::new, BlocksRegistry.STOVE).build(null);
    public static final BlockEntityType<CookingPotBlockEntity> COOKING_POT_ENTITY = FabricBlockEntityTypeBuilder.create(CookingPotBlockEntity::new, BlocksRegistry.COOKING_POT).build(null);
    public static final BlockEntityType<BasketBlockEntity> BASKET_ENTITY = FabricBlockEntityTypeBuilder.create(BasketBlockEntity::new, BlocksRegistry.BASKET).build(null);
    public static final BlockEntityType<CuttingBoardBlockEntity> CUTTING_BOARD_ENTITY = FabricBlockEntityTypeBuilder.create(CuttingBoardBlockEntity::new, BlocksRegistry.CUTTING_BOARD).build(null);
    public static final BlockEntityType<PantryBlockEntity> PANTRY_ENTITY = FabricBlockEntityTypeBuilder.create(PantryBlockEntity::new, BlocksRegistry.OAK_PANTRY).addBlock(BlocksRegistry.BIRCH_PANTRY).addBlock(BlocksRegistry.SPRUCE_PANTRY).addBlock(BlocksRegistry.JUNGLE_PANTRY).addBlock(BlocksRegistry.ACACIA_PANTRY).addBlock(BlocksRegistry.DARK_OAK_PANTRY).build(null);

    public static void registerBlockEntities() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(RedBrainsTweaks.MOD_ID, "placed_tool"), PLACED_TOOL_ENTITY);
//        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(RedBrainsTweaks.MOD_ID, "stove"), STOVE_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(RedBrainsTweaks.MOD_ID, "cooking_pot"), COOKING_POT_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(RedBrainsTweaks.MOD_ID, "basket"), BASKET_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(RedBrainsTweaks.MOD_ID, "cutting_board"), CUTTING_BOARD_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(RedBrainsTweaks.MOD_ID, "pantry"), PANTRY_ENTITY);
    }
}
