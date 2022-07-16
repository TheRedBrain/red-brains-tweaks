package com.github.theredbrain.redbrainstweaks.registry;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum SoundsRegistry {
    BLOCK_COOKING_POT_BOIL("block.cooking_pot.boil"),
    BLOCK_CUTTING_BOARD_KNIFE("block.cutting_board.knife"),
    BLOCK_STOVE_CRACKLE("block.stove.crackle"),
    ITEM_TOMATO_PICK_FROM_BUSH("item.tomato.pick_from_bush");

    private final String pathName;
    private final SoundEvent soundEvent;

    SoundsRegistry(String pathName) {
        this.pathName = pathName;
        this.soundEvent = new SoundEvent(new Identifier(RedBrainsTweaks.MOD_ID, this.pathName));
    }

    public static void registerAll() {
        for (SoundsRegistry value : values()) {
            Registry.register(Registry.SOUND_EVENT, new Identifier(RedBrainsTweaks.MOD_ID, value.pathName), value.soundEvent);
        }
    }

    public SoundEvent get() {
        return soundEvent;
    }
}