package com.github.theredbrain.redbrainstweaks.item;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class FireStarterItem extends Item {

    public FireStarterItem(Settings settings) {
        super(settings);
    }

    // TODO make using not instantly

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        boolean bl = false;
        boolean success = false;
        if(Random.create().nextInt(10) <= 0) {
            success = true;
        }
        if (!CampfireBlock.canBeLit(blockState) && !CandleBlock.canBeLit(blockState) && !CandleCakeBlock.canBeLit(blockState)) {
            blockPos = blockPos.offset(context.getSide());
            if (AbstractFireBlock.canPlaceAt(world, blockPos, context.getPlayerFacing())) {
                this.playUseSound(world, blockPos, success);
                if (success) {
                    world.setBlockState(blockPos, AbstractFireBlock.getState(world, blockPos));
                    world.emitGameEvent(context.getPlayer(), GameEvent.BLOCK_PLACE, blockPos);
                }
                bl = true;
            }
        } else {
            this.playUseSound(world, blockPos, success);
            if (success) {
                world.setBlockState(blockPos, (BlockState) blockState.with(Properties.LIT, true));
                world.emitGameEvent(context.getPlayer(), GameEvent.BLOCK_PLACE, blockPos);
            }
            bl = true;
        }

        if (bl) {
            if (context.getPlayer() != null) {
                context.getStack().damage(1, context.getPlayer(), (player) -> {
                    player.sendToolBreakStatus(context.getHand());
                });
            }
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.FAIL;
        }
    }

    private void playUseSound(World world, BlockPos pos, Boolean success) {
        Random random = world.getRandom();
        if (success) {
            world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
        } else {
            world.playSound((PlayerEntity) null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
        }
    }
}
