package com.github.theredbrain.redbrainstweaks.registry;

import com.github.theredbrain.redbrainstweaks.block.entity.PlacedToolEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntitiesRegistry {
    public static final BlockEntityType<PlacedToolEntity> PLACED_TOOL_ENTITY = FabricBlockEntityTypeBuilder.create(PlacedToolEntity::new, BlocksRegistry.PLACED_TOOL_BLOCK).build(null);;

    public static void registerEntities() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("redbrainstweaks", "obese"), PLACED_TOOL_ENTITY);
    }
}
