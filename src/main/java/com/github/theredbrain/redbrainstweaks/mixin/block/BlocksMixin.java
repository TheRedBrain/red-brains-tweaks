package com.github.theredbrain.redbrainstweaks.mixin.block;

import com.github.theredbrain.redbrainstweaks.block.CustomDirtBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public class BlocksMixin {

    @Redirect(method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=dirt")),
            at = @At(value = "NEW",
                    target = "net/minecraft/block/Block",
                    ordinal = 0
            )
    )
    private static Block redirectedDirt(Block.Settings settings) {
        return new CustomDirtBlock(settings);
    }
}
