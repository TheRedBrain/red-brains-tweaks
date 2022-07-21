package com.github.theredbrain.redbrainstweaks.block.plants;

import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.function.Supplier;

public class RedMushroomPlantBlock extends MushroomPlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
    private final Supplier<RegistryEntry<? extends ConfiguredFeature<?, ?>>> feature;
    public RedMushroomPlantBlock(Settings settings, Supplier<RegistryEntry<? extends ConfiguredFeature<?, ?>>> feature) {
        super(settings, feature);
        this.feature = feature;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState blockState = world.getBlockState(pos.down());
        if (random.nextInt(50) == 0 && world.getBaseLightLevel(pos, 0) < 1 && blockState.isOf(BlocksRegistry.RICH_SOIL)) {
            // growing into mushroom colony
            BlockState newState = BlocksRegistry.RED_MUSHROOM_COLONY.getDefaultState();
            if (world.getLightLevel(pos.up(), 0) < 13 && newState.canPlaceAt(world, pos)) {
                world.setBlockState(pos, newState);
            }

        } else if (random.nextInt(100) == 0 && blockState.isOf(Blocks.MYCELIUM)) {
            // growing into big mushroom
            world.removeBlock(pos, false);
            if (!(((ConfiguredFeature)((RegistryEntry)this.feature.get()).value()).generate(world, world.getChunkManager().getChunkGenerator(), random, pos))) {
                world.setBlockState(pos, state, 3);
            }
        }

    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return world.getBaseLightLevel(pos, 0) < 13 && this.canPlantOnTop(blockState, world, blockPos);
        }
    }
}
