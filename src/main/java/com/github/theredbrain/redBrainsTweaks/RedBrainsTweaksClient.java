package com.github.theredbrain.redBrainsTweaks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;

public class RedBrainsTweaksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockColors();
        registerItemColors();
        registerTransparency();
    }

    private void registerBlockColors() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : -1;
        }, RedBrainsTweaks.SUGAR_CANE_ROOT_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
        }, RedBrainsTweaks.ACACIA_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
        }, RedBrainsTweaks.BIRCH_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
        }, RedBrainsTweaks.DARK_OAK_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
        }, RedBrainsTweaks.JUNGLE_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
        }, RedBrainsTweaks.OAK_STUMP_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
        }, RedBrainsTweaks.SPRUCE_STUMP_BLOCK);
    }

    private void registerItemColors() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), RedBrainsTweaks.ACACIA_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), RedBrainsTweaks.BIRCH_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), RedBrainsTweaks.DARK_OAK_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), RedBrainsTweaks.JUNGLE_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), RedBrainsTweaks.OAK_STUMP_BLOCK);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D), RedBrainsTweaks.SPRUCE_STUMP_BLOCK);
    }

    private void registerTransparency() {
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.CACTUS_ROOT_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.SUGAR_CANE_ROOT_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.NETHERITE_CAULDRON_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.NETHERITE_LAVA_CAULDRON_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.ACACIA_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.BIRCH_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.DARK_OAK_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.JUNGLE_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.OAK_STUMP_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.SPRUCE_STUMP_BLOCK, RenderLayer.getCutout());
    }
}
