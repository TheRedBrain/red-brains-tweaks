package com.github.theredbrain.redbrainstweaks.block;

import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import com.github.theredbrain.redbrainstweaks.util.BlockStateUtils;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class MushroomColonyBlock extends PlantBlock {

    public static final IntProperty AGE = Properties.AGE_3;
    public static final int MAX_AGE = 3;

    protected static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.createCuboidShape(4.d, .0d, 4.d, 12.d, 8.d, 12.d),
            Block.createCuboidShape(3.d, .0d, 3.d, 13.d, 10.d, 13.d),
            Block.createCuboidShape(2.d, .0d, 2.d, 14.d, 12.d, 14.d),
            Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 14.d, 15.d)};

    private final Item mushroomType;

    public MushroomColonyBlock(Settings settings, Item mushroomType) {
        super(settings);
        this.mushroomType = mushroomType;
        setDefaultState(getStateManager().getDefaultState().with(AGE, 0));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = state.get(AGE);
        BlockState groundState = world.getBlockState(pos.down());
        if (age < MAX_AGE && groundState.getBlock() == BlocksRegistry.RICH_SOIL && world.getLightLevel(pos.up(), 0) == 0 && random.nextInt(25) == 0) {
            world.setBlockState(pos, state.with(AGE, age + 1), BlockStateUtils.BLOCK_UPDATE);
        }
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(mushroomType);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(AGE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);
        ItemStack heldItem = player.getStackInHand(hand);

        if (age > 0 && heldItem.getItem() instanceof ShearsItem) {
            dropStack(world, pos, getPickStack(world, pos, state));
            world.playSound(null, pos, SoundEvents.ENTITY_MOOSHROOM_SHEAR, SoundCategory.BLOCKS, 1.f, 1.f);
            world.setBlockState(pos, state.with(AGE, age - 1), BlockStateUtils.BLOCK_UPDATE);
            if (!world.isClient()) {
                heldItem.damage(1, player, playerIn -> playerIn.sendToolBreakStatus(hand));
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_AGE[state.get(AGE)];
    }

}
