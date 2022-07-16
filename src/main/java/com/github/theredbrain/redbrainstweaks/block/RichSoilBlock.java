package com.github.theredbrain.redbrainstweaks.block;

import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import com.github.theredbrain.redbrainstweaks.tags.Tags;
import com.github.theredbrain.redbrainstweaks.util.BlockStateUtils;
import com.github.theredbrain.redbrainstweaks.util.MathUtils;
import com.github.theredbrain.redbrainstweaks.util.WorldEventUtils;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.Set;

public class RichSoilBlock extends Block {
    public static final int COLONY_FORMING_LIGHT_LEVEL = 12;

    public RichSoilBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() instanceof HoeItem && state.getBlock() == BlocksRegistry.RICH_SOIL &&
                hit.getSide() != Direction.DOWN && world.getBlockState(pos.up()).isAir()) {
            world.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.f, 1.f);
            if (!world.isClient()) {
                world.setBlockState(pos, BlocksRegistry.RICH_SOIL_FARMLAND.getDefaultState(), BlockStateUtils.DEFAULT_AND_RERENDER);
                itemStack.damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(hand));
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient()) {
            BlockPos abovePos = pos.up();
            BlockState aboveState = world.getBlockState(abovePos);
            Block aboveBlock = aboveState.getBlock();

            // Do nothing if the plant is unaffected by rich soil
            if (aboveState.isIn(Tags.UNAFFECTED_BY_RICH_SOIL) || aboveBlock instanceof TallFlowerBlock) {
                return;
            }

            // Convert mushrooms to colonies if it's dark enough
            if (!tryConvertToColonies(world, pos, aboveState) && (aboveBlock instanceof Fertilizable growable
                    && MathUtils.RAND.nextFloat() <= .2f && growable.isFertilizable(world, pos.up(), aboveState, false))) {
                growable.grow(world, world.getRandom(), pos.up(), aboveState);
                world.syncWorldEvent(WorldEventUtils.BONEMEAL_PARTICLES, pos.up(), 0);
            }
        }
    }

    private boolean tryConvertToColonies(World world, BlockPos pos, BlockState state) {
        if (!Set.of(Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM).contains(state.getBlock())) {
            return false;
        }

        BlockState newState = state.isOf(Blocks.BROWN_MUSHROOM) ? BlocksRegistry.BROWN_MUSHROOM_COLONY.getDefaultState() : BlocksRegistry.RED_MUSHROOM_COLONY.getDefaultState();
        if (world.getLightLevel(pos.up(), 0) <= COLONY_FORMING_LIGHT_LEVEL) {
            world.setBlockState(pos.up(), newState);
        }

        return true;
    }

}
