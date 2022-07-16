package com.github.theredbrain.redbrainstweaks.mixin.entity;

import com.github.theredbrain.redbrainstweaks.effect.ComfortEffect;
import com.github.theredbrain.redbrainstweaks.enchantment.BackstabbingEnchantment;
import com.github.theredbrain.redbrainstweaks.item.KnifeItem;
import com.github.theredbrain.redbrainstweaks.registry.EnchantmentsRegistry;
import com.github.theredbrain.redbrainstweaks.registry.StatusEffectsRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    public abstract Map<StatusEffect, StatusEffectInstance> getActiveStatusEffects();

    @Shadow
    @Nullable
    public abstract LivingEntity getAttacker();

    @ModifyVariable(at = @At("HEAD"), method = "takeKnockback(DDD)V", ordinal = 0, argsOnly = true)
    private double takeKnockbackStrength(double strength) {
        LivingEntity attacker = getAttacker();
        ItemStack tool = attacker != null ? attacker.getStackInHand(attacker.getActiveHand()) : ItemStack.EMPTY;

        if (tool.getItem() instanceof KnifeItem) {
            return strength - .1d;
        } else {
            return strength;
        }
    }

    @Inject(at = @At("HEAD"), method = "canHaveStatusEffect", cancellable = true)
    private void canHaveStatusEffect(StatusEffectInstance effect, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (getActiveStatusEffects().containsKey(StatusEffectsRegistry.COMFORT) && ComfortEffect.COMFORT_IMMUNITIES.contains(effect.getEffectType())) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @ModifyVariable(at = @At("HEAD"), method = "damage", argsOnly = true)
    private float takeDamage(float amount, DamageSource source, float originalAmount) {
        Entity attacker = source.getAttacker();
        if (attacker instanceof PlayerEntity player) {
            ItemStack weapon = player.getMainHandStack();
            int level = EnchantmentHelper.getLevel(EnchantmentsRegistry.BACKSTABBING.get(), weapon);
            if (level > 0 && BackstabbingEnchantment.isLookingBehindTarget((LivingEntity)(Object)this, source.getPosition())) {
                World world = attacker.getEntityWorld();
                if (!world.isClient()) {
                    world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.BLOCKS, 1.f, 1.f);

                    return BackstabbingEnchantment.getBackstabbingDamagePerLevel(originalAmount, level);
                }
            }
        }

        return amount;
    }

}