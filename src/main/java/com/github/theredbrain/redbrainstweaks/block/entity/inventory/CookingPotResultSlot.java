package com.github.theredbrain.redbrainstweaks.block.entity.inventory;

import com.github.theredbrain.redbrainstweaks.inventory.ItemHandler;
import com.github.theredbrain.redbrainstweaks.inventory.SlotItemHandler;
import net.minecraft.item.ItemStack;

public class CookingPotResultSlot extends SlotItemHandler {
    public CookingPotResultSlot(ItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }
}