package com.github.theredbrain.redbrainstweaks.item;

import com.github.theredbrain.redbrainstweaks.block.MushroomColonyBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import org.jetbrains.annotations.Nullable;

public class MushroomColonyBlockItem extends BlockItem {
    public MushroomColonyBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Nullable
    @Override
    protected BlockState getPlacementState(ItemPlacementContext context) {
        BlockState blockState = getBlock().getPlacementState(context);
        if (blockState != null) {
            BlockState matureState = blockState.with(MushroomColonyBlock.AGE, 3);
            return canPlace(context, matureState) ? matureState : null;
        }

        return null;
    }
}