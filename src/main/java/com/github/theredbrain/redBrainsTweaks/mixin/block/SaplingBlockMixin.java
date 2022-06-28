package com.github.theredbrain.redBrainsTweaks.mixin.block;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.block.SaplingBlock;
//import net.minecraft.block.sapling.SaplingGenerator;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.state.property.IntProperty;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.random.Random;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.World;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.gen.Accessor;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(SaplingBlock.class)
//public class SaplingBlockMixin {
//
//    @Shadow
//    @Final
//    public static IntProperty STAGE;
//
//    @Shadow
//    public void generate(ServerWorld world, BlockPos pos, BlockState state, Random random) {
//        throw new AssertionError();
//    }
//
//    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
//    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
//        if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(63) == 0) {
//            this.generate(world, pos, state, random);
//        }
//        ci.cancel();
//    }
//
//    @Inject(method = "generate", at = @At("HEAD"), cancellable = true)
//    public void generateMoreStages(ServerWorld world, BlockPos pos, BlockState state, Random random) {
//        if ((Integer)state.get(STAGE) <= 3) {
//            world.setBlockState(pos, (BlockState)state.cycle(STAGE), 4);
//        } else {
//            // accessor for the generator
//            this.generator.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
//        }
//
//    }
//
//    @Inject(method = "isFertilizable", at = @At("RETURN"), cancellable = true)
//    public void isNotFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient, CallbackInfoReturnable<Boolean> cir) {
//        cir.setReturnValue(false);
//    }
//
//    @Inject(method = "canGrow", at = @At("RETURN"), cancellable = true)
//    public void canNotGrow(World world, Random random, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
//        cir.setReturnValue(false);
//    }
//}
