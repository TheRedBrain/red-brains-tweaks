package com.github.theredbrain.redBrainsTweaks.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CrippledStatusEffect extends StatusEffect {
    public CrippledStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 3381504 /*TODO correct color*/);
    }
}
