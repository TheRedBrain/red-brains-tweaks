package com.github.theredbrain.redBrainsTweaks.world;

import com.github.theredbrain.redBrainsTweaks.RedBrainsTweaks;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;

public class DarkOakStumpTreeDecorator extends TreeDecorator {

    public static final Codec<DarkOakStumpTreeDecorator> CODEC;
    private final BlockStateProvider provider;

    public DarkOakStumpTreeDecorator(BlockStateProvider provider) {
        this.provider = provider;
    }
    @Override
    protected TreeDecoratorType<?> getType() {
        return RedBrainsTweaks.DARK_OAK_STUMP;
    }

    @Override
    public void generate(Generator generator) {

        // TODO implement checks
        List<BlockPos> list = generator.getLogPositions();
//        ((BlockPos)list.get(0))
        int stumpLevel = list.get(4).getY();
        int i = 4;
        while (list.get(i).getY() == stumpLevel) {
//            for (int i = 4; i <= 7; i++) {
            generator.replace((BlockPos) list.get(i), provider.getBlockState(generator.getRandom(), (BlockPos) list.get(i)));
            i++;
        }
    }

    static {
        CODEC = BlockStateProvider.TYPE_CODEC.fieldOf("stump_provider").xmap(DarkOakStumpTreeDecorator::new, (decorator) -> {
            return decorator.provider;
        }).codec();
    }
}
