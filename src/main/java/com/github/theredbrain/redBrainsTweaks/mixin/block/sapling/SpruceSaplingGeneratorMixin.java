package com.github.theredbrain.redBrainsTweaks.mixin.block.sapling;

import com.github.theredbrain.redBrainsTweaks.RedBrainsTweaks;
import net.minecraft.block.sapling.SpruceSaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpruceSaplingGenerator.class)
public class SpruceSaplingGeneratorMixin {

    @Inject(method = "getTreeFeature", at = @At("HEAD"), cancellable = true)
    protected void getCustomTreeFeature(Random random, boolean bees, CallbackInfoReturnable<RegistryEntry<? extends ConfiguredFeature<?, ?>>> cir) {
        cir.setReturnValue(RedBrainsTweaks.CUSTOM_SPRUCE);
    }

    @Inject(method = "getLargeTreeFeature", at = @At("HEAD"), cancellable = true)
    protected void getLargeCustomTreeFeature(Random random, CallbackInfoReturnable<RegistryEntry<? extends ConfiguredFeature<?, ?>>> cir) {
        cir.setReturnValue(random.nextBoolean() ? RedBrainsTweaks.CUSTOM_MEGA_SPRUCE : RedBrainsTweaks.CUSTOM_MEGA_PINE);
    }
}
