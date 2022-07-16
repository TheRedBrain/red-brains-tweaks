package com.github.theredbrain.redbrainstweaks.registry;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import com.github.theredbrain.redbrainstweaks.effect.*;
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
    
    // food
    public static final StatusEffect COMFORT = new ComfortEffect();
    public static final StatusEffect NOURISHED = new NourishmentEffect();

    public static void registerEffects() {
        // low hunger bar
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "peckish"), PECKISH);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "hungry"), HUNGRY);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "famished"), FAMISHED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "starving"), STARVING);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "dying"), DYING);

        // low health bar
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "hurt"), HURT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "injured"), INJURED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "wounded"), WOUNDED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "crippled"), CRIPPLED);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "agonizing"), AGONIZING);

        // high fat/saturation bar
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "plump"), PLUMP);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "chubby"), CHUBBY);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "fat"), FAT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "obese"), OBESE);
        
        // food
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "comfort"), COMFORT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(RedBrainsTweaks.MOD_ID, "nourished"), NOURISHED);
    }
}
