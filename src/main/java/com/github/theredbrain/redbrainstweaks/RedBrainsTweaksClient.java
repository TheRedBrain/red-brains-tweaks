package com.github.theredbrain.redbrainstweaks;

import com.github.theredbrain.redbrainstweaks.client.render.block.entity.PlacedToolRenderer;
import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import com.github.theredbrain.redbrainstweaks.registry.EntitiesRegistry;
import com.github.theredbrain.redbrainstweaks.registry.ItemsRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;

public class RedBrainsTweaksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockColors();
        registerItemColors();
        registerRenderer();
        registerTransparency();
    }

    private void registerBlockColors() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 14188339, BlocksRegistry.WET_CLAY_BRICK_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : -1, BlocksRegistry.SUGAR_CANE_ROOT_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.ACACIA_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.BIRCH_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.DARK_OAK_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.JUNGLE_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.OAK_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.SPRUCE_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register(((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D)), BlocksRegistry.GRASS_SLAB);
    }

    private void registerItemColors() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.ACACIA_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.BIRCH_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.DARK_OAK_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.JUNGLE_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.OAK_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.SPRUCE_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), BlocksRegistry.GRASS_SLAB);
    }

    private void registerRenderer() {
        BlockEntityRendererRegistry.register(EntitiesRegistry.PLACED_TOOL_ENTITY, PlacedToolRenderer::new);
    }

    private void registerTransparency() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.CACTUS_ROOT_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.SUGAR_CANE_ROOT_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.WET_CLAY_BRICK_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.NETHERITE_CAULDRON_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.NETHERITE_LAVA_CAULDRON_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.ACACIA_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.BIRCH_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.DARK_OAK_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.JUNGLE_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.OAK_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.PLACED_TOOL_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.GRASS_SLAB, RenderLayer.getCutoutMipped());
    }
}
