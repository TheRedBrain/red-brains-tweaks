package com.github.theredbrain.redbrainstweaks.item;

import com.github.theredbrain.redbrainstweaks.registry.StatusEffectsRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class Foods {
    // Forage
    public static final FoodComponent CABBAGE = (new FoodComponent.Builder()).hunger(2).saturationModifier(.1f).build();
    public static final FoodComponent HAM = (new FoodComponent.Builder()).hunger(5).saturationModifier(.3f).build();
    public static final FoodComponent ONION = (new FoodComponent.Builder()).hunger(2).saturationModifier(.2f).build();
    public static final FoodComponent TOMATO = (new FoodComponent.Builder()).hunger(1).saturationModifier(.1f).build();

    // Basic Foods
    public static final FoodComponent BACON = (new FoodComponent.Builder()).hunger(2).saturationModifier(.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), .3f).meat().build();
    public static final FoodComponent BEEF_PATTY = (new FoodComponent.Builder()).hunger(3).saturationModifier(.6f).meat().build();
    public static final FoodComponent CABBAGE_LEAF = (new FoodComponent.Builder()).hunger(1).saturationModifier(.1f).build();
    public static final FoodComponent CHICKEN_CUTS = (new FoodComponent.Builder()).hunger(2).saturationModifier(.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), .3f).meat().build();
    public static final FoodComponent COD_SLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), .7f).build();
    public static final FoodComponent COOKED_BACON = (new FoodComponent.Builder()).hunger(3).saturationModifier(.6f).meat().build();
    public static final FoodComponent COOKED_CHICKEN_CUTS = (new FoodComponent.Builder()).hunger(3).saturationModifier(.6f).meat().build();
    public static final FoodComponent COOKED_COD_SLICE = (new FoodComponent.Builder()).hunger(3).saturationModifier(.6f).build();
    public static final FoodComponent COOKED_MUTTON_CHOPS = (new FoodComponent.Builder()).hunger(3).saturationModifier(.6f).meat().build();
    public static final FoodComponent COOKED_SALMON_SLICE = (new FoodComponent.Builder()).hunger(3).saturationModifier(.6f).build();
    public static final FoodComponent FRIED_EGG = (new FoodComponent.Builder()).hunger(2).saturationModifier(.3f).build();
    public static final FoodComponent MINCED_BEEF = (new FoodComponent.Builder()).hunger(2).saturationModifier(.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), .3f).meat().build();
    public static final FoodComponent MUTTON_CHOPS = (new FoodComponent.Builder()).hunger(2).saturationModifier(.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), .3f).meat().build();
    public static final FoodComponent PIE_CRUST = (new FoodComponent.Builder()).hunger(5).saturationModifier(.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1200, 1), 1.f).build();
    public static final FoodComponent PUMPKIN_SLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(.3f).build();
    public static final FoodComponent RAW_EGG = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 1.0F).snack().alwaysEdible().build();
    public static final FoodComponent RAW_PASTA = (new FoodComponent.Builder()).hunger(2).saturationModifier(.1f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1200, 1), 1.f).build();
    public static final FoodComponent SALMON_SLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(.3f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), .7f).build();
    public static final FoodComponent SMOKED_HAM = (new FoodComponent.Builder()).hunger(7).saturationModifier(.6f).build();
    public static final FoodComponent TOMATO_SAUCE = (new FoodComponent.Builder()).hunger(2).saturationModifier(.4f).build();
    public static final FoodComponent WHEAT_DOUGH = (new FoodComponent.Builder()).hunger(2).saturationModifier(.2f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), .5f).build();

    // Sweets
    public static final FoodComponent CAKE_SLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(2.f).build();
    public static final FoodComponent FRUIT_SALAD = (new FoodComponent.Builder()).hunger(5).saturationModifier(1.f).build();
    public static final FoodComponent PIE_SLICE = (new FoodComponent.Builder()).hunger(4).saturationModifier(2.f).build();
    public static final FoodComponent POPSICLE = (new FoodComponent.Builder()).hunger(2).saturationModifier(3.f).snack().alwaysEdible().build();

    // Handheld Foods
    public static final FoodComponent BACON_SANDWICH = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).build();
    public static final FoodComponent BARBECUE_STICK = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).build();
    public static final FoodComponent CABBAGE_ROLLS = (new FoodComponent.Builder()).hunger(5).saturationModifier(.5f).build();
    public static final FoodComponent CHICKEN_SANDWICH = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).build();
    public static final FoodComponent DUMPLINGS = (new FoodComponent.Builder()).hunger(6).saturationModifier(.6f).build();
    public static final FoodComponent EGG_SANDWICH = (new FoodComponent.Builder()).hunger(4).saturationModifier(.6f).build();
    public static final FoodComponent HAMBURGER = (new FoodComponent.Builder()).hunger(10).saturationModifier(.6f).build();
    public static final FoodComponent MIXED_SALAD = (new FoodComponent.Builder()).hunger(5).saturationModifier(.2f).build();
    public static final FoodComponent MUTTON_WRAP = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).build();
    public static final FoodComponent NETHER_SALAD = (new FoodComponent.Builder()).hunger(4).saturationModifier(.2f).build();
    public static final FoodComponent STUFFED_POTATO = (new FoodComponent.Builder()).hunger(7).saturationModifier(.6f).build();

    // Bowl Foods
    public static final FoodComponent BAKED_COD_STEW = (new FoodComponent.Builder()).hunger(7).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.COMFORT, 2400, 0), 1.f).build();
    public static final FoodComponent BEEF_STEW = (new FoodComponent.Builder()).hunger(7).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.COMFORT, 2400, 0), 1.f).build();
    public static final FoodComponent CHICKEN_SOUP = (new FoodComponent.Builder()).hunger(7).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.COMFORT, 2400, 0), 1.f).build();
    public static final FoodComponent COOKED_RICE = (new FoodComponent.Builder()).hunger(4).saturationModifier(.4f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.COMFORT, 600, 0), 1.f).build();
    public static final FoodComponent FISH_STEW = (new FoodComponent.Builder()).hunger(8).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.COMFORT, 2400, 0), 1.f).build();
    public static final FoodComponent FRIED_RICE = (new FoodComponent.Builder()).hunger(8).saturationModifier(.4f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.COMFORT, 2400, 0), 1.f).build();
    public static final FoodComponent NOODLE_SOUP = (new FoodComponent.Builder()).hunger(10).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.COMFORT, 2400, 0), 1.f).build();
    public static final FoodComponent PUMPKIN_SOUP = (new FoodComponent.Builder()).hunger(7).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.COMFORT, 2400, 0), 1.f).build();
    public static final FoodComponent VEGETABLE_SOUP = (new FoodComponent.Builder()).hunger(10).saturationModifier(.4f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.COMFORT, 2400, 0), 1.f).build();

    // Plated Foods
    public static final FoodComponent GRILLED_SALMON = (new FoodComponent.Builder()).hunger(6).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();
    public static final FoodComponent HONEY_GLAZED_HAM = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();
    public static final FoodComponent PASTA_WITH_MEATBALLS = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();
    public static final FoodComponent PASTA_WITH_MUTTON_CHOP = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();
    public static final FoodComponent RATATOUILLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(.2f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 1200, 0), 1.f).build();
    public static final FoodComponent ROAST_CHICKEN = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();
    public static final FoodComponent ROASTED_MUTTON_CHOPS = (new FoodComponent.Builder()).hunger(6).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();
    public static final FoodComponent SHEPHERDS_PIE = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();
    public static final FoodComponent SQUID_INK_PASTA = (new FoodComponent.Builder()).hunger(6).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();
    public static final FoodComponent STEAK_AND_POTATOES = (new FoodComponent.Builder()).hunger(6).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 2400, 0), 1.f).build();
    public static final FoodComponent STUFFED_PUMPKIN = (new FoodComponent.Builder()).hunger(4).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();
    public static final FoodComponent VEGETABLE_NOODLES = (new FoodComponent.Builder()).hunger(6).saturationModifier(.4f).statusEffect(new StatusEffectInstance(StatusEffectsRegistry.NOURISHED, 4800, 0), 1.f).build();

    // Other Foods
    public static final FoodComponent DOG_FOOD = (new FoodComponent.Builder()).hunger(5).saturationModifier(.6f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 1.f).meat().build();
}