package com.github.theredbrain.redbrainstweaks.block;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import com.github.theredbrain.redbrainstweaks.block.entity.PlacedToolEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class PlacedToolBlock extends Block implements BlockEntityProvider {
    public static final DirectionProperty FACING;
    public static final VoxelShape SHAPENORTH;
    public static final VoxelShape SHAPEWEST;
    public static final VoxelShape SHAPEEAST;
    public static final VoxelShape SHAPESOUTH;
//    public static final EnumProperty<ToolItem> PLACED_TOOL;

    public PlacedToolBlock(Settings settings/*, ToolItem placedTool*/) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.getDefaultState()).with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PlacedToolEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        PlacedToolEntity placedToolEntity = (PlacedToolEntity) world.getBlockEntity(pos);
        ItemStack stack = placedToolEntity.getStack(0);
        if (!stack.isEmpty() && player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
            // Remove hanging item
//            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            if (!world.isClient && !player.giveItemStack(stack.split(1))) {
                player.dropItem(stack.split(1), false);
            }
//            world.playSound(null, pos, SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.PLAYERS, 0.8F, 0.8F); // TODO find better sound
            placedToolEntity.clear();

            world.removeBlock(pos, false);
            world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);

            return ActionResult.success(world.isClient);
        }

        return ActionResult.FAIL;
    }

//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
//        switch ((Direction) state.get(FACING)) {
//            case NORTH:
//                return SHAPENORTH;
//            case SOUTH:
//                return SHAPESOUTH;
//            case WEST:
//                return SHAPEWEST;
//            case EAST:
//                return SHAPEEAST;
//            default:
//                return SHAPEEAST;
//        }
//    }
//
//    @Override
//    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
//        PlacedToolEntity placedToolEntity = (PlacedToolEntity) world.getBlockEntity(pos);
//        ItemStack stack = placedToolEntity.getStack(0);
//        if (stack.getItem() instanceof PickaxeItem) {
//            return state.isIn(BlockTags.PICKAXE_MINEABLE) && state.isSideSolidFullSquare(world, pos, Direction.UP);
//        } else if (stack.getItem() instanceof AxeItem) {
//            return state.isIn(BlockTags.AXE_MINEABLE) && state.isSideSolidFullSquare(world, pos, Direction.UP);
//        } else if (stack.getItem() instanceof ShovelItem) {
//            return state.isIn(BlockTags.SHOVEL_MINEABLE) && state.isSideSolidFullSquare(world, pos, Direction.UP);
//        } else if (stack.getItem() instanceof SwordItem) {
//            return (state.isIn(BlockTags.AXE_MINEABLE) || state.isIn(BlockTags.SHOVEL_MINEABLE)) && state.isSideSolidFullSquare(world, pos, Direction.UP);
//        } else {
//            return false;
//        }
//    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (direction == Direction.DOWN) {
            return Blocks.AIR.getDefaultState();
        } else {

            return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
        }
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState2;
        if (!ctx.canReplaceExisting()) {
            blockState2 = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(ctx.getSide().getOpposite()));
            if (blockState2.getBlock() == this && blockState2.get(FACING) == ctx.getSide()) {
                return null;
            }
        }

        blockState2 = this.getDefaultState();
        Direction[] var6 = ctx.getPlacementDirections();
        int var7 = var6.length;

        for (int var8 = 0; var8 < var7; ++var8) {
            Direction direction = var6[var8];
            if (direction.getAxis().isHorizontal()) {
                return (BlockState) blockState2.with(FACING, direction.getOpposite());
            }
        }

        return null;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Inventory) {
                ItemScatterer.spawn(world, pos, (Inventory) blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @SuppressWarnings("unchecked")
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> checkType(BlockEntityType<A> givenType, BlockEntityType<E> expectedType,
                                                                                                   BlockEntityTicker<? super E> ticker) {
        return expectedType == givenType ? (BlockEntityTicker<A>) ticker : null;
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        SHAPESOUTH = Block.createCuboidShape(0D, 13D, 0D, 16D, 16D, 3D);
        SHAPEEAST = Block.createCuboidShape(0D, 13D, 0D, 3D, 16D, 16D);
        SHAPEWEST = Block.createCuboidShape(13D, 13D, 0D, 16D, 16D, 16D);
        SHAPENORTH = Block.createCuboidShape(0D, 13D, 13D, 16D, 16D, 16D);
//        PLACED_TOOL = EnumProperty.of("placed_tool", ToolItem.class);
    }

    // container for 1 itemstack

    // only some blocks viable for each tool controlled by block tags

    // mixins into tool classes for shift-right click behaviour

    // look at FleshZ for rendering
}
