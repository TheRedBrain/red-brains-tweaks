package com.github.theredbrain.redbrainstweaks.block.plants;

import com.github.theredbrain.redbrainstweaks.block.CustomFarmlandBlock;
import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import com.github.theredbrain.redbrainstweaks.tags.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class WheatCropBlock extends CustomCropBlock {

    private static final IntProperty AGE;
    public static final IntProperty UPPER_CROP;

    //TODO lower fully grown part only drops straw
    // upper fully grown part drops wheat
    // wheat can be crafted into 2 wheat seeds or (ground) into 1 flour

    public WheatCropBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(AGE, 0).with(UPPER_CROP, 0));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{AGE, UPPER_CROP});
    }

    public IntProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    protected ItemConvertible getSeedsItem() {
        return Items.WHEAT_SEEDS;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            world.setBlockState(pos, this.withAge(this.getAge(state)).with(HAS_WEED_GROWN, state.get(HAS_WEED_GROWN)).with(POLLINATED, state.get(POLLINATED)).with(UPPER_CROP, state.get(UPPER_CROP)).with(WEED_AGE, 0), 2);
        }

        return ActionResult.PASS;
    }

    // crop growth is affected by pollination from bees, fertilization of farmland and moisturized farmland
    // each of these factors doubles the chance of the crop growing
    // growth is paused, when the weed is present
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState blockState = world.getBlockState(pos.down());
        if (world.isSkyVisible(pos) && world.getBaseLightLevel(pos, 0) >= 9 && blockState.isIn(Tags.FARM_LAND)) {
            int i = this.getAge(state);
            float f = getAvailableMoisture(world, pos);
            boolean fertilizedFarmland = (blockState.isIn(Tags.FERTILIZABLE_FARM_LAND) && blockState.get(CustomFarmlandBlock.FERTILIZED) || blockState.isIn(Tags.NON_FERTILIZABLE_FARM_LAND));
            if (i < this.getMaxAge() - 1 && state.get(WEED_AGE) == 0) {
                if (random.nextInt((int)(((fertilizedFarmland && state.get(POLLINATED)) ? 50.0F : (fertilizedFarmland || state.get(POLLINATED)) ? 100.0F : 200.0F) / f) + 1) == 0) {
                    world.setBlockState(pos, this.withAge(i + 1).with(HAS_WEED_GROWN, state.get(HAS_WEED_GROWN)).with(POLLINATED, false).with(UPPER_CROP, 0).with(WEED_AGE, state.get(WEED_AGE)), 2);
                }
            } else if (i == this.getMaxAge() - 1 && state.get(WEED_AGE) == 0) {
                if (random.nextInt((int)(((fertilizedFarmland && state.get(POLLINATED)) ? 50.0F : (fertilizedFarmland || state.get(POLLINATED)) ? 100.0F : 200.0F) / f) + 1) == 0 && BlocksRegistry.WHEAT_UPPER_CROP.withAge(0).canPlaceAt(world, pos.up())) {
                    world.setBlockState(pos, this.withAge(i + 1).with(HAS_WEED_GROWN, state.get(HAS_WEED_GROWN)).with(POLLINATED, false).with(UPPER_CROP, 1).with(WEED_AGE, state.get(WEED_AGE)), 2);
                    world.setBlockState(pos.up(), BlocksRegistry.WHEAT_UPPER_CROP.withAge(0).with(CustomUpperCropBlock.POLLINATED, false), 2);
                }
            }

            if (!blockState.isIn(Tags.NO_WEED_FARM_LAND) && world.isNight() && !state.get(HAS_WEED_GROWN)) {
                int j = state.get(WEED_AGE);
                if (j < 3) {
                    if (random.nextInt(100) == 0) {
                        world.setBlockState(pos, withAge(this.getAge(state)).with(HAS_WEED_GROWN, true).with(POLLINATED, state.get(POLLINATED)).with(UPPER_CROP, state.get(UPPER_CROP)).with(WEED_AGE, state.get(WEED_AGE) + 1), 2);
                    }
                } else {
                    world.setBlockState(pos, BlocksRegistry.WEED_BLOCK.getDefaultState().with(WeedBlock.AGE, 4));
                }
            } else if (!world.isNight() && state.get(HAS_WEED_GROWN)) {
                world.setBlockState(pos, state.with(HAS_WEED_GROWN, false));
            }
        }

    }

    static {
        AGE = Properties.AGE_7;
        AGE_TO_SHAPE = new VoxelShape[]{
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
        };
        UPPER_CROP = IntProperty.of("upper_crop", 0, 4);
    }
}
