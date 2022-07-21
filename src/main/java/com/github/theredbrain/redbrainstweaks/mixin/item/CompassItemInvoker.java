package com.github.theredbrain.redbrainstweaks.mixin.item;

import net.minecraft.item.CompassItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CompassItem.class)
public interface CompassItemInvoker {

    @Invoker("writeNbt")
    void invokeWriteNbt(RegistryKey<World> worldKey, BlockPos pos, NbtCompound nbt);
}
