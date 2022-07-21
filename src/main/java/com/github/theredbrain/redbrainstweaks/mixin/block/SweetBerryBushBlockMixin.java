package com.github.theredbrain.redbrainstweaks.mixin.block;

import com.github.theredbrain.redbrainstweaks.registry.BlocksRegistry;
import com.github.theredbrain.redbrainstweaks.registry.ItemsRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SweetBerryBushBlock.class)
public class SweetBerryBushBlockMixin {

    @Shadow
    @Final
    public static IntProperty AGE;

    @Inject(method = "getPickStack", at = @At("RETURN"), cancellable = true)
    public void pickBushBlock(BlockView world, BlockPos pos, BlockState state, CallbackInfoReturnable<ItemStack> cir) {
        cir.setReturnValue(new ItemStack(Blocks.SWEET_BERRY_BUSH));
    }

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void takesLongerToGrow(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        int i = (Integer)state.get(AGE);
        BlockState blockState = world.getBlockState(pos.down());
        if (i < 3 && random.nextInt(blockState.isOf(BlocksRegistry.RICH_SOIL) ? 10 : 20) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            BlockState newState = (BlockState)state.with(AGE, i + 1);
            world.setBlockState(pos, newState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(newState));
        }
        ci.cancel();
    }

    @Inject(method = "isFertilizable", at = @At("RETURN"), cancellable = true)
    public void isNotFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "canGrow", at = @At("RETURN"), cancellable = true)
    public void canNotGrow(World world, Random random, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

}
