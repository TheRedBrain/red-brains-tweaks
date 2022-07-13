package com.github.theredbrain.redBrainsTweaks.mixin.item;

import com.github.theredbrain.redBrainsTweaks.RedBrainsTweaks;
import com.github.theredbrain.redBrainsTweaks.block.IngotBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public class ItemsMixin {

    @Redirect(method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=brick")),
            at = @At(value = "NEW",
                    target = "net/minecraft/item/Item",
                    ordinal = 0
            )
    )
    private static Item redirectedBrick(Item.Settings settings) {
        return new BlockItem(RedBrainsTweaks.BRICK_BLOCK, settings.group(ItemGroup.MATERIALS));
    }

    @Redirect(method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=nether_brick")),
            at = @At(value = "NEW",
                    target = "net/minecraft/item/Item",
                    ordinal = 0
            )
    )
    private static Item redirectedNetherBrick(Item.Settings settings) {
        return new BlockItem(RedBrainsTweaks.NETHER_BRICK_BLOCK, settings.group(ItemGroup.MATERIALS));
    }

    @Redirect(method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=iron_ingot")),
            at = @At(value = "NEW",
                    target = "net/minecraft/item/Item",
                    ordinal = 0
            )
    )
    private static Item redirectedIronIngot(Item.Settings settings) {
        return new BlockItem(RedBrainsTweaks.IRON_INGOT_BLOCK, settings.group(ItemGroup.MATERIALS));
    }

    @Redirect(method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=copper_ingot")),
            at = @At(value = "NEW",
                    target = "net/minecraft/item/Item",
                    ordinal = 0
            )
    )
    private static Item redirectedCopperIngot(Item.Settings settings) {
        return new BlockItem(RedBrainsTweaks.COPPER_INGOT_BLOCK, settings.group(ItemGroup.MATERIALS));
    }

    @Redirect(method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=gold_ingot")),
            at = @At(value = "NEW",
                    target = "net/minecraft/item/Item",
                    ordinal = 0
            )
    )
    private static Item redirectedGoldIngot(Item.Settings settings) {
        return new BlockItem(RedBrainsTweaks.GOLD_INGOT_BLOCK, settings.group(ItemGroup.MATERIALS));
    }

    @Redirect(method = "<clinit>",
            slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=netherite_ingot")),
            at = @At(value = "NEW",
                    target = "net/minecraft/item/Item",
                    ordinal = 0
            )
    )
    private static Item redirectedNetheriteIngot(Item.Settings settings) {
        return new BlockItem(RedBrainsTweaks.NETHERITE_INGOT_BLOCK, settings.group(ItemGroup.MATERIALS).fireproof());
    }
}
