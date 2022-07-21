package com.github.theredbrain.redbrainstweaks.block;

import com.github.theredbrain.redbrainstweaks.block.enums.SidingDirection;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class SidingBlock extends SlabBlock {

    public static final EnumProperty<SidingDirection> DIRECTION;
    public static final DirectionProperty FACING;
    protected static final VoxelShape VERTICAL_SHAPE_NORTH;
    protected static final VoxelShape VERTICAL_SHAPE_EAST;
    protected static final VoxelShape VERTICAL_SHAPE_SOUTH;
    protected static final VoxelShape VERTICAL_SHAPE_WEST;

    public SidingBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.getDefaultState().with(DIRECTION, SidingDirection.HORIZONTAL)).with(FACING, Direction.NORTH));
    }

    public boolean hasSidedTransparency(BlockState state) {
        return state.get(TYPE) != SlabType.DOUBLE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{DIRECTION, FACING});
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        SlabType slabType = (SlabType)state.get(TYPE);
        SidingDirection direction = state.get(DIRECTION);
        Direction facing = state.get(FACING);
        if (slabType == SlabType.DOUBLE) {
            return VoxelShapes.fullCube();
        } else if (direction == SidingDirection.HORIZONTAL) {
            if (slabType == SlabType.TOP) {
                return TOP_SHAPE;
            }
            return BOTTOM_SHAPE;
        } else {
            return switch (facing) {
                case EAST -> VERTICAL_SHAPE_EAST;
                case SOUTH -> VERTICAL_SHAPE_SOUTH;
                case WEST -> VERTICAL_SHAPE_WEST;
                default -> VERTICAL_SHAPE_NORTH;
            };
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = ctx.getWorld().getBlockState(blockPos);
        if (blockState.isOf(this)) {
            return (BlockState)((BlockState)blockState.with(TYPE, SlabType.DOUBLE)).with(WATERLOGGED, false);
        } else {
            FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
            BlockState blockState2 = (BlockState)((BlockState)this.getDefaultState().with(DIRECTION, SidingDirection.HORIZONTAL).with(FACING, Direction.NORTH).with(TYPE, SlabType.BOTTOM)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
            Direction direction = ctx.getSide();
            return direction == Direction.UP ? blockState2 : direction == Direction.EAST ? blockState2.with(DIRECTION, SidingDirection.VERTICAL).with(FACING, Direction.WEST) : direction == Direction.WEST ? blockState2.with(DIRECTION, SidingDirection.VERTICAL).with(FACING, Direction.EAST) : direction == Direction.SOUTH ? blockState2.with(DIRECTION, SidingDirection.VERTICAL).with(FACING, Direction.NORTH) : direction == Direction.NORTH ? blockState2.with(DIRECTION, SidingDirection.VERTICAL).with(FACING, Direction.SOUTH) : (BlockState)blockState2.with(TYPE, SlabType.TOP);
        }
    }

    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        ItemStack itemStack = context.getStack();
        SlabType slabType = (SlabType)state.get(TYPE);
        SidingDirection sidingDirection = state.get(DIRECTION);
        Direction facing = state.get(FACING);
        if (slabType != SlabType.DOUBLE && itemStack.isOf(this.asItem())) {
            if (context.canReplaceExisting()) {
                Direction placingDirection = context.getSide();
                if (sidingDirection == SidingDirection.HORIZONTAL) {
                    if (slabType == SlabType.BOTTOM) {
                        return placingDirection == Direction.UP;
                    } else {
                        return placingDirection == Direction.DOWN;
                    }
                } else {
                    if (facing == Direction.EAST) {
                        return placingDirection == Direction.WEST;
                    } else if (facing == Direction.SOUTH) {
                        return placingDirection == Direction.NORTH;
                    } else if (facing == Direction.WEST) {
                        return placingDirection == Direction.EAST;
                    } else {
                        return placingDirection == Direction.SOUTH;
                    }
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public FluidState getFluidState(BlockState state) {
        return super.getFluidState(state);
    }

    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        return super.tryFillWithFluid(world, pos, state, fluidState);
    }

    public boolean canFillWithFluid(BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return super.canFillWithFluid(world, pos, state,fluid);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return super.canPathfindThrough(state, world, pos, type);
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        DIRECTION = EnumProperty.of("direction", SidingDirection.class);
        VERTICAL_SHAPE_NORTH = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
        VERTICAL_SHAPE_EAST = Block.createCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        VERTICAL_SHAPE_SOUTH = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
        VERTICAL_SHAPE_WEST = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    }
}
