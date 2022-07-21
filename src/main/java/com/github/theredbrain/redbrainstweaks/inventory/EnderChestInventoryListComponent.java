package com.github.theredbrain.redbrainstweaks.inventory;


import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.inventory.EnderChestInventory;

import java.util.List;

public interface EnderChestInventoryListComponent extends ComponentV3 {
    List<EnderChestInventory> getSharedEnderChestInventories();
}
