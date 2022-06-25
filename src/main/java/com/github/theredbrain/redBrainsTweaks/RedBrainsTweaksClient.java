package com.github.theredbrain.redBrainsTweaks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;

public class RedBrainsTweaksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerColors();
        registerTransparency();
    }

    private void registerColors() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : -1;
        }, RedBrainsTweaks.SUGAR_CANE_ROOT_BLOCK);
    }

    private void registerTransparency() {
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.CACTUS_ROOT_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RedBrainsTweaks.SUGAR_CANE_ROOT_BLOCK, RenderLayer.getCutout());
    }
}
