package com.github.theredbrain.redbrainstweaks.registry;

import com.github.theredbrain.redbrainstweaks.entity.effect.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class StatusEffectsRegistry {

    // low hunger bar
    public static final StatusEffect PECKISH = new PeckishStatusEffect();
    public static final StatusEffect HUNGRY = new HungryStatusEffect();
    public static final StatusEffect FAMISHED = new FamishedStatusEffect();
    public static final StatusEffect STARVING = new StarvingStatusEffect();
    public static final StatusEffect DYING = new DyingStatusEffect();

    // low health bar
    public static final StatusEffect HURT = new HurtStatusEffect();
    public static final StatusEffect INJURED = new InjuredStatusEffect();
    public static final StatusEffect WOUNDED = new WoundedStatusEffect();
    public static final StatusEffect CRIPPLED = new CrippledStatusEffect();
    public static final StatusEffect AGONIZING = new AgonizingStatusEffect();

    // high fat/saturation bar
    public static final StatusEffect PLUMP = new PlumpStatusEffect();
    public static final StatusEffect CHUBBY = new ChubbyStatusEffect();
    public static final StatusEffect FAT = new FatStatusEffect();
    public static final StatusEffect OBESE = new ObeseStatusEffect();

    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "peckish"), PECKISH);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "hungry"), HUNGRY);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "famished"), FAMISHED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "starving"), STARVING);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "dying"), DYING);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "hurt"), HURT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "injured"), INJURED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "wounded"), WOUNDED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "crippled"), CRIPPLED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "agonizing"), AGONIZING);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "plump"), PLUMP);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "chubby"), CHUBBY);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "fat"), FAT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("redbrainstweaks", "obese"), OBESE);
    }
}
