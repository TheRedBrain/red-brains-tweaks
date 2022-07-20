package com.github.theredbrain.redbrainstweaks.block.plants;

import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import com.github.theredbrain.redbrainstweaks.tags.Tags;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.*;

public class WeedBlock extends PlantBlock {
    public static final IntProperty AGE;
    private static final VoxelShape[] AGE_TO_SHAPE;
    public static final BooleanProperty HAS_WEED_GROWN;


    public WeedBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 1));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(AGE) - 1];
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(Tags.FARM_LAND);
    }

    public boolean hasRandomTicks(BlockState state) {
        return state.get(AGE) <= 4;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState blockState = world.getBlockState(pos.down());
        if (!blockState.isIn(Tags.NO_WEED_FARM_LAND) && world.isNight() && !state.get(HAS_WEED_GROWN)) {
            int j = state.get(AGE);
            if (j <= 3) {
                if (random.nextInt(100) == 0) {
                    world.setBlockState(pos, state.with(AGE, state.get(AGE) + 1).with(HAS_WEED_GROWN, true), 2);
                }
            }
        } else if (!world.isNight() && state.get(HAS_WEED_GROWN)) {
            world.setBlockState(pos, state.with(HAS_WEED_GROWN, false));
        }
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient() && state.get(AGE) < 4) {
            world.breakBlock(pos, false);
        }

        return ActionResult.PASS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        BlockState blockState = world.getBlockState(pos.down());
        if (!newState.isOf(this) && state.get(AGE) == 4 && blockState.isIn(Tags.FARM_LAND)) {
            if (blockState.isOf(BlocksRegistry.CUSTOM_FARMLAND_BLOCK)) {
                world.setBlockState(pos.down(), BlocksRegistry.LOOSE_DIRT_BLOCK.getDefaultState());
            } else if (blockState.isOf(BlocksRegistry.RICH_SOIL_FARMLAND)) {
                world.setBlockState(pos.down(), BlocksRegistry.RICH_SOIL.getDefaultState());
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(this);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{AGE, HAS_WEED_GROWN});
    }

    static {
        AGE = IntProperty.of("age", 1, 4);
        AGE_TO_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)};
        HAS_WEED_GROWN = BooleanProperty.of("has_weed_grown");
    }
}
