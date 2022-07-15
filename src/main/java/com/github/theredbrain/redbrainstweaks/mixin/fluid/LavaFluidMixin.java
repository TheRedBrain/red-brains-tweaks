package com.github.theredbrain.redbrainstweaks.mixin.fluid;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LavaFluid.class)
public class LavaFluidMixin {

    @Inject(method = "getBucketItem", at = @At("HEAD"), cancellable = true)
    public void getBucketItem(CallbackInfoReturnable<Item> cir) {
        cir.setReturnValue(RedBrainsTweaks.NETHERITE_LAVA_BUCKET_ITEM);
    }
}
