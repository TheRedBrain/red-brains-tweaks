package com.github.theredbrain.redbrainstweaks.block.plants;

import com.github.theredbrain.redbrainstweaks.block.CustomFarmlandBlock;
import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import com.github.theredbrain.redbrainstweaks.tags.Tags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;

public class WheatUpperCropBlock extends CustomUpperCropBlock {

    public static final IntProperty AGE;

    public WheatUpperCropBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    public IntProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 3;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(AGE);
    }

    public Block getLowerCrop() {
        return BlocksRegistry.CUSTOM_WHEAT_BLOCK;
    }

    protected ItemConvertible getSeedsItem() {
        return BlocksRegistry.CUSTOM_WHEAT_BLOCK;
    }

    // crop growth is affected by pollination from bees, fertilization of farmland and moisturized farmland
    // each of these factors doubles the chance of the crop growing
    // growth is paused, when the weed is present
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState lowerCropState = world.getBlockState(pos.down());
        BlockState farmlandState = world.getBlockState(pos.down(2));
        if (world.isSkyVisible(pos) && world.getBaseLightLevel(pos, 0) >= 9 && lowerCropState.isOf(this.getLowerCrop())) {
            int i = this.getAge(state);
            if (i < this.getMaxAge() && lowerCropState.get(CustomCropBlock.WEED_AGE) == 0) {
                float f = getAvailableMoisture(world, pos);
                boolean fertilizedFarmland = (farmlandState.isIn(Tags.FERTILIZABLE_FARM_LAND) && farmlandState.get(CustomFarmlandBlock.FERTILIZED) || farmlandState.isIn(Tags.NON_FERTILIZABLE_FARM_LAND));
                if (random.nextInt((int)(((fertilizedFarmland && state.get(POLLINATED)) ? 50.0F : (fertilizedFarmland || state.get(POLLINATED)) ? 100.0F : 200.0F) / f) + 1) == 0) {
                    world.setBlockState(pos, this.withAge(i + 1).with(POLLINATED, false), 2);
                    world.setBlockState(pos.down(), BlocksRegistry.CUSTOM_WHEAT_BLOCK.withAge(7).with(WheatCropBlock.HAS_WEED_GROWN, lowerCropState.get(WheatCropBlock.HAS_WEED_GROWN)).with(WheatCropBlock.POLLINATED, false).with(WheatCropBlock.UPPER_CROP, i + 2).with(WheatCropBlock.WEED_AGE, lowerCropState.get(CustomCropBlock.WEED_AGE)), 2);
                }
            }
        }

    }

    static {
        AGE = Properties.AGE_3;
        AGE_TO_SHAPE = new VoxelShape[]{
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D),
        };
    }
}
