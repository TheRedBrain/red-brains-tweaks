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

public class RichSoilBlock extends FallingBlock {
    public static final int COLONY_FORMING_LIGHT_LEVEL = 0;

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
}
