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

public abstract class CustomUpperCropBlock extends PlantBlock {

    protected static VoxelShape[] AGE_TO_SHAPE;
    public static final BooleanProperty POLLINATED;


    public CustomUpperCropBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.withAge(0).with(POLLINATED, false)));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(this.getLowerCrop());
    }

    public abstract Block getLowerCrop();

    public abstract IntProperty getAgeProperty();

    public abstract int getMaxAge();

    protected int getAge(BlockState state) {
        return (Integer)state.get(this.getAgeProperty());
    }

    public BlockState withAge(int age) {
        return (BlockState)this.stateManager.getDefaultState().with(this.getAgeProperty(), age);
    }

    public boolean hasRandomTicks(BlockState state) {
        return this.getAge(state) < this.getMaxAge();
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
                }
            }
        }

    }

    protected static float getAvailableMoisture(BlockView world, BlockPos pos) {

        return CustomCropBlock.getAvailableMoisture(world, pos.down());
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return (world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos)) && world.getBlockState(pos.down()).isOf(this.getLowerCrop());
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof RavagerEntity && world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            world.breakBlock(pos, true, entity);
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    protected abstract ItemConvertible getSeedsItem();

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(this.getSeedsItem());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{POLLINATED});
    }

    static {
        POLLINATED = BooleanProperty.of("pollinated");
    }
}
