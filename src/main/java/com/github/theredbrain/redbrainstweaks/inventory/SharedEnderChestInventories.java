package com.github.theredbrain.redbrainstweaks.inventory;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.world.WorldProperties;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SharedEnderChestInventories implements EnderChestInventoryListComponent, AutoSyncedComponent {
    // TODO fix enderchest

    private EnderChestInventory worldSharedEnderChestInventory;
    private EnderChestInventory firstOverworldSharedEnderChestInventory;
    private EnderChestInventory secondOverworldSharedEnderChestInventory;
    private EnderChestInventory firstNetherSharedEnderChestInventory;
    private EnderChestInventory secondNetherSharedEnderChestInventory;
    private EnderChestInventory firstEndSharedEnderChestInventory;
    private EnderChestInventory secondEndSharedEnderChestInventory;
    private List<EnderChestInventory> sharedEnderChestInventories;
    private final WorldProperties provider;

    public SharedEnderChestInventories(WorldProperties provider) {
        this.worldSharedEnderChestInventory = new EnderChestInventory();
        this.firstOverworldSharedEnderChestInventory = new EnderChestInventory();
        this.secondOverworldSharedEnderChestInventory = new EnderChestInventory();
        this.firstNetherSharedEnderChestInventory = new EnderChestInventory();
        this.secondNetherSharedEnderChestInventory = new EnderChestInventory();
        this.firstEndSharedEnderChestInventory = new EnderChestInventory();
        this.secondEndSharedEnderChestInventory = new EnderChestInventory();
        this.sharedEnderChestInventories = List.of(this.worldSharedEnderChestInventory, this.firstOverworldSharedEnderChestInventory, this.secondOverworldSharedEnderChestInventory, this.firstNetherSharedEnderChestInventory, this.secondNetherSharedEnderChestInventory, this.firstEndSharedEnderChestInventory, this.secondEndSharedEnderChestInventory);
        this.provider = provider;
    }

    @Override
    public List<EnderChestInventory> getSharedEnderChestInventories() {
        return this.sharedEnderChestInventories;
    }

    @Override
    public void readFromNbt(@NotNull NbtCompound tag) {
        for (int i = 0; i < tag.getSize(); ++i) {
            NbtList items = (NbtList) tag.get("items" + i);
            this.sharedEnderChestInventories.get(i).readNbtList(items);
        }
    }

    @Override
    public void writeToNbt(@NotNull NbtCompound tag) {
        for (int i = 0; i < this.sharedEnderChestInventories.size(); ++i) {
            if (this.sharedEnderChestInventories.get(i).isEmpty()) {
                continue;
            }
            tag.put("items"+i, this.sharedEnderChestInventories.get(i).toNbtList());
        }
    }
}
