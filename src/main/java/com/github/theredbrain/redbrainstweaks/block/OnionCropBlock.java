package com.github.theredbrain.redbrainstweaks.block;

import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;

public class OnionCropBlock extends CropBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 2.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 3.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 4.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 5.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 6.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 7.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 8.d, 16.d),
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 9.d, 16.d)
    };

    public OnionCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return BlocksRegistry.ONION_CROP;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, net.minecraft.world.BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_AGE[state.get(getAgeProperty())];
    }
}