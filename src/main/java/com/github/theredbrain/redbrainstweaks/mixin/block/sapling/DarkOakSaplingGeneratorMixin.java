package com.github.theredbrain.redbrainstweaks.mixin.block.sapling;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import net.minecraft.block.sapling.DarkOakSaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DarkOakSaplingGenerator.class)
public class DarkOakSaplingGeneratorMixin {

    @Nullable
    @Inject(method = "getLargeTreeFeature", at = @At("HEAD"), cancellable = true)
    protected void getLargeCustomTreeFeature(Random random, CallbackInfoReturnable<RegistryEntry<? extends ConfiguredFeature<?, ?>>> cir) {
        cir.setReturnValue(RedBrainsTweaks.CUSTOM_DARK_OAK);
    }
}
