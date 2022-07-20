package com.github.theredbrain.redbrainstweaks.world;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;

public class StumpTreeDecorator extends TreeDecorator {

    public static final Codec<StumpTreeDecorator> CODEC;
    private final BlockStateProvider provider;

    public StumpTreeDecorator(BlockStateProvider provider) {
        this.provider = provider;
    }
    @Override
    protected TreeDecoratorType<?> getType() {
        return RedBrainsTweaks.STUMP;
    }

    @Override
    public void generate(Generator generator) {

        List<BlockPos> list = generator.getLogPositions();
        generator.replace((BlockPos)list.get(1), provider.getBlockState(generator.getRandom(), (BlockPos)list.get(1)));
    }

    static {
        CODEC = BlockStateProvider.TYPE_CODEC.fieldOf("stump_provider").xmap(StumpTreeDecorator::new, (decorator) -> decorator.provider).codec();
    }
}
