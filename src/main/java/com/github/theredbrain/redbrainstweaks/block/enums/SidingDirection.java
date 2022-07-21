package com.github.theredbrain.redbrainstweaks.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum SidingDirection implements StringIdentifiable {
    HORIZONTAL("horizontal"),
    VERTICAL("vertical");

    private final String name;

    private SidingDirection(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
