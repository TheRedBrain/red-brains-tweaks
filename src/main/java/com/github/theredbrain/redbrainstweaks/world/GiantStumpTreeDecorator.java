package com.github.theredbrain.redbrainstweaks.world;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;

public class GiantStumpTreeDecorator extends TreeDecorator {

    public static final Codec<GiantStumpTreeDecorator> CODEC;
    private final BlockStateProvider provider;

    public GiantStumpTreeDecorator(BlockStateProvider provider) {
        this.provider = provider;
    }
    @Override
    protected TreeDecoratorType<?> getType() {
        return RedBrainsTweaks.GIANT_STUMP;
    }

    @Override
    public void generate(Generator generator) {

        List<BlockPos> list = generator.getLogPositions();
        for (int i = 4; i <= 7; i++) {
            generator.replace((BlockPos) list.get(i), provider.getBlockState(generator.getRandom(), (BlockPos) list.get(i)));
        }
    }

    static {
        CODEC = BlockStateProvider.TYPE_CODEC.fieldOf("stump_provider").xmap(GiantStumpTreeDecorator::new, (decorator) -> decorator.provider).codec();
    }
}
