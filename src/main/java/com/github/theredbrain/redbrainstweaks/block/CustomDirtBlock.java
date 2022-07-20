package com.github.theredbrain.redbrainstweaks.block;

import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import com.github.theredbrain.redbrainstweaks.tags.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;

import java.util.Iterator;

public class CustomDirtBlock extends Block {

    public CustomDirtBlock(Settings settings) {
        super(settings);
    }

    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        loosenNeighboringDirt(world, pos);
    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);

        ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);
        if (!itemStack.isEmpty() && (itemStack.isIn(Tags.PROPER_DIGGING_TOOLS))) {
            loosenNeighboringDirt(world, pos);
        } else if (!itemStack.isEmpty()) {
            boolean bl = false;
            if (itemStack.hasEnchantments()) {
                for (int i = 0; i <= itemStack.getEnchantments().size(); i++) {
                    if (itemStack.getEnchantments().get(i).equals((Object) Enchantments.SILK_TOUCH)) {
                        bl = true;
                    }
                }
            }
            if (!bl) {
                loosenNeighboringDirt(world, pos);
            }
        } else {
            loosenNeighboringDirt(world, pos);
        }

        world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(player, state));
    }

    private void loosenNeighboringDirt(World world, BlockPos pos) {
        Iterator var2 = BlockPos.iterate(pos.add(-1, 0, -1), pos.add(1, 1, 1)).iterator();

        do {
            if (!var2.hasNext()) {
                break;
            }

            BlockPos blockPos = (BlockPos)var2.next();
            if (world.getBlockState(blockPos).isOf(Blocks.DIRT)) {
                world.setBlockState(blockPos, BlocksRegistry.LOOSE_DIRT_BLOCK.getDefaultState());
            } else if (world.getBlockState(blockPos).isOf(BlocksRegistry.DIRT_SLAB)) {
                world.setBlockState(blockPos, BlocksRegistry.LOOSE_DIRT_SLAB.getDefaultState());
            }
        } while(var2.hasNext());
    }
}
