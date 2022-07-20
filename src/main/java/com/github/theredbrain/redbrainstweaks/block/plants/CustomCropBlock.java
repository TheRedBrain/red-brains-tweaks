package com.github.theredbrain.redbrainstweaks.block.plants;

import com.github.theredbrain.redbrainstweaks.block.CustomFarmlandBlock;
import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import com.github.theredbrain.redbrainstweaks.tags.Tags;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.*;

public abstract class CustomCropBlock extends PlantBlock {

    protected static VoxelShape[] AGE_TO_SHAPE;
    public static final BooleanProperty HAS_WEED_GROWN;
    public static final BooleanProperty POLLINATED;
    public static final IntProperty WEED_AGE;


    public CustomCropBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.withAge(0).with(HAS_WEED_GROWN, false).with(POLLINATED, false).with(WEED_AGE, 0)));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            world.setBlockState(pos, this.withAge(this.getAge(state)).with(HAS_WEED_GROWN, state.get(HAS_WEED_GROWN)).with(POLLINATED, state.get(POLLINATED)).with(WEED_AGE, 0), 2);
        }

        return ActionResult.PASS;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(Tags.FARM_LAND) || floor.isIn(Tags.FARM_LAND_PLANTER);
    }

    public abstract IntProperty getAgeProperty();

    public abstract int getMaxAge();

    protected int getAge(BlockState state) {
        return (Integer)state.get(this.getAgeProperty());
    }

    public BlockState withAge(int age) {
        return (BlockState)this.stateManager.getDefaultState().with(this.getAgeProperty(), age);
    }

    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    // crop growth is affected by pollination from bees, fertilization of farmland and moisturized farmland
    // each of these factors doubles the chance of the crop growing
    // growth is paused, when the weed is present
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState blockState = world.getBlockState(pos.down());
        if (world.isSkyVisible(pos) && world.getBaseLightLevel(pos, 0) >= 9 && blockState.isIn(Tags.FARM_LAND)) {
            int i = this.getAge(state);
            if (i < this.getMaxAge() && state.get(WEED_AGE) == 0) {
                float f = getAvailableMoisture(world, pos);
                boolean fertilizedFarmland = (blockState.isIn(Tags.FERTILIZABLE_FARM_LAND) && blockState.get(CustomFarmlandBlock.FERTILIZED) || blockState.isIn(Tags.NON_FERTILIZABLE_FARM_LAND));
                if (random.nextInt((int)(((fertilizedFarmland && state.get(POLLINATED)) ? 50.0F : (fertilizedFarmland || state.get(POLLINATED)) ? 100.0F : 200.0F) / f) + 1) == 0) {
                    world.setBlockState(pos, this.withAge(i + 1).with(HAS_WEED_GROWN, state.get(HAS_WEED_GROWN)).with(POLLINATED, false).with(WEED_AGE, state.get(WEED_AGE)), 2);
                }
            }

            if (!blockState.isIn(Tags.NO_WEED_FARM_LAND) && world.isNight() && !state.get(HAS_WEED_GROWN)) {
                int j = state.get(WEED_AGE);
                if (j < 3) {
                    if (random.nextInt(100) == 0) {
                        world.setBlockState(pos, withAge(this.getAge(state)).with(HAS_WEED_GROWN, true).with(POLLINATED, state.get(POLLINATED)).with(WEED_AGE, state.get(WEED_AGE) + 1), 2);
                    }
                } else {
                    world.setBlockState(pos, BlocksRegistry.WEED_BLOCK.getDefaultState().with(WeedBlock.AGE, 4));
                }
            } else if (!world.isNight() && state.get(HAS_WEED_GROWN)) {
                world.setBlockState(pos, state.with(HAS_WEED_GROWN, false));
            }
        }

    }

    protected static float getAvailableMoisture(BlockView world, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isIn(Tags.FARM_LAND) && blockState.get(FarmlandBlock.MOISTURE) >= 0) {
            f = 2.0F;
        }

        return f;
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return (world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos)) && super.canPlaceAt(state, world, pos);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof RavagerEntity && world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            world.breakBlock(pos, true, entity);
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        BlockState blockState = world.getBlockState(pos.down());
        if (!(newState.isOf(this) || newState.isOf(BlocksRegistry.WEED_BLOCK)) && blockState.isIn(Tags.FARM_LAND)) {
            if (blockState.isOf(BlocksRegistry.CUSTOM_FARMLAND_BLOCK)) {
                world.setBlockState(pos.down(), BlocksRegistry.LOOSE_DIRT_BLOCK.getDefaultState());
            } else if (blockState.isOf(BlocksRegistry.RICH_SOIL_FARMLAND)) {
                world.setBlockState(pos.down(), BlocksRegistry.RICH_SOIL.getDefaultState());
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    protected abstract ItemConvertible getSeedsItem();

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(this.getSeedsItem());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{HAS_WEED_GROWN, POLLINATED, WEED_AGE});
    }

    static {
        HAS_WEED_GROWN = BooleanProperty.of("has_weed_grown");
        POLLINATED = BooleanProperty.of("pollinated");
        WEED_AGE = IntProperty.of("weed_age", 0, 3);
    }
}
