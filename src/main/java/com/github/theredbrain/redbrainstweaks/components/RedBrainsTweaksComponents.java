package com.github.theredbrain.redbrainstweaks.components;

import com.github.theredbrain.redbrainstweaks.inventory.SharedEnderChestInventories;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.level.LevelComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.level.LevelComponentInitializer;
import net.minecraft.util.Identifier;

public final class RedBrainsTweaksComponents implements LevelComponentInitializer {

    public static final ComponentKey<SharedEnderChestInventories> SHARED_ENDER_CHEST_INVENTORIES =
            ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier("redbrainstweaks:shared-ender-chest-inventories"), SharedEnderChestInventories.class);

    @Override
    public void registerLevelComponentFactories(LevelComponentFactoryRegistry registry) {
        registry.register(SHARED_ENDER_CHEST_INVENTORIES, level -> new SharedEnderChestInventories(level));
    }
}
