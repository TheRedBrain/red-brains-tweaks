package com.github.theredbrain.redBrainsTweaks.mixin.block.sapling;

import com.github.theredbrain.redBrainsTweaks.RedBrainsTweaks;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OakSaplingGenerator.class)
public class OakSaplingGeneratorMixin {

    @Inject(method = "getTreeFeature", at = @At("HEAD"), cancellable = true)
    protected void getCustomTreeFeature(Random random, boolean bees, CallbackInfoReturnable<RegistryEntry<? extends ConfiguredFeature<?, ?>>> cir) {
        if (random.nextInt(10) == 0) {
            cir.setReturnValue(bees ? RedBrainsTweaks.CUSTOM_FANCY_OAK_BEES_005 : RedBrainsTweaks.CUSTOM_FANCY_OAK);
        } else {
            cir.setReturnValue(bees ? RedBrainsTweaks.CUSTOM_OAK_BEES_005 : RedBrainsTweaks.CUSTOM_OAK);
        }
    }
}
