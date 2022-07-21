package com.github.theredbrain.redbrainstweaks.mixin.block;

import com.github.theredbrain.redbrainstweaks.block.BricksBlock;
import com.github.theredbrain.redbrainstweaks.block.CustomDirtBlock;
import com.github.theredbrain.redbrainstweaks.block.SidingBlock;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

import java.util.function.Supplier;

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

    @Redirect(method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=bricks")),
            at = @At(value = "NEW",
                    target = "net/minecraft/block/Block",
                    ordinal = 0
            )
    )
    private static Block redirectedBricks(Block.Settings settings) {
        return new BricksBlock(settings);
    }
}
