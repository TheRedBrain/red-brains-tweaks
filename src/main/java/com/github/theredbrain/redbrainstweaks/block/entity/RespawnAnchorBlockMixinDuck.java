package com.github.theredbrain.redbrainstweaks.block.entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface RespawnAnchorBlockMixinDuck {
    boolean isStillValid(World world, BlockPos pos);
}
