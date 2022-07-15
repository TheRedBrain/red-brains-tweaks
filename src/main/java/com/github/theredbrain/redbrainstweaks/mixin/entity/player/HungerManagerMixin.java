package com.github.theredbrain.redbrainstweaks.mixin.entity.player;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HungerManager.class)
public abstract class HungerManagerMixin {

	@Shadow
	private int foodLevel;

	@Shadow
	private float saturationLevel;

	@Shadow
	private float exhaustion;

	@Shadow
	private int foodTickTimer;

	@Shadow
	private int prevFoodLevel;

	int regenTick = 0;

	@Inject(method = "add", at = @At("HEAD"), cancellable = true)
	public void addExcessiveFoodToSaturation(int food, float saturationModifier, CallbackInfo ci) {
		float foodToSaturation = -20 + this.foodLevel + food;
		this.foodLevel = Math.min(food + this.foodLevel, 20);
		this.saturationLevel = Math.min(this.saturationLevel + Math.max(foodToSaturation * saturationModifier, 0), (float)this.foodLevel);
		ci.cancel();
	}

	@Inject(at = @At("HEAD"), method = "update", cancellable = true)
	private void hardcoreRegeneration(PlayerEntity player, CallbackInfo ci) {
		Difficulty difficulty = player.world.getDifficulty();
		this.prevFoodLevel = this.foodLevel;
		if (this.exhaustion > 4.0F) {
			this.exhaustion -= 4.0F;
			if (this.saturationLevel > this.foodLevel) {
				this.saturationLevel = Math.max(this.saturationLevel - 1.0F, 0.0F);
			} else if (difficulty != Difficulty.PEACEFUL) {
				this.foodLevel = Math.max(this.foodLevel - 1, 0);
			}
		}

		if (this.saturationLevel >= 18) {
			player.removeStatusEffect(RedBrainsTweaks.PLUMP);
			player.removeStatusEffect(RedBrainsTweaks.CHUBBY);
			player.removeStatusEffect(RedBrainsTweaks.FAT);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.OBESE, 25, 0, true, false, false));
		} else if (this.saturationLevel >= 16) {
			player.removeStatusEffect(RedBrainsTweaks.PLUMP);
			player.removeStatusEffect(RedBrainsTweaks.CHUBBY);
			player.removeStatusEffect(RedBrainsTweaks.OBESE);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.FAT, 25, 0, true, false, false));
		} else if (this.saturationLevel >= 14) {
			player.removeStatusEffect(RedBrainsTweaks.PLUMP);
			player.removeStatusEffect(RedBrainsTweaks.FAT);
			player.removeStatusEffect(RedBrainsTweaks.OBESE);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.CHUBBY, 25, 0, true, false, false));
		} else if (this.saturationLevel >= 12) {
			player.removeStatusEffect(RedBrainsTweaks.CHUBBY);
			player.removeStatusEffect(RedBrainsTweaks.FAT);
			player.removeStatusEffect(RedBrainsTweaks.OBESE);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.PLUMP, 25, 0, true, false, false));
		} else {
			player.removeStatusEffect(RedBrainsTweaks.PLUMP);
			player.removeStatusEffect(RedBrainsTweaks.CHUBBY);
			player.removeStatusEffect(RedBrainsTweaks.FAT);
			player.removeStatusEffect(RedBrainsTweaks.OBESE);
		}

		boolean bl = player.world.getGameRules().getBoolean(GameRules.NATURAL_REGENERATION);

		if (this.foodLevel > 8) {
			player.removeStatusEffect(RedBrainsTweaks.PECKISH);
			player.removeStatusEffect(RedBrainsTweaks.HUNGRY);
			player.removeStatusEffect(RedBrainsTweaks.FAMISHED);
			player.removeStatusEffect(RedBrainsTweaks.STARVING);
			player.removeStatusEffect(RedBrainsTweaks.DYING);

			if(bl && player.getHealth() < player.getMaxHealth()) {
				++this.foodTickTimer;
				++this.regenTick;
				if (this.regenTick >= 600) {
					this.regenTick = 0;
					player.heal(1);
				}
			}
		} else if (this.foodLevel > 6) {
			player.removeStatusEffect(RedBrainsTweaks.HUNGRY);
			player.removeStatusEffect(RedBrainsTweaks.FAMISHED);
			player.removeStatusEffect(RedBrainsTweaks.STARVING);
			player.removeStatusEffect(RedBrainsTweaks.DYING);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.PECKISH, 25, 0, true, false, false));
		} else if (this.foodLevel > 4) {
			player.removeStatusEffect(RedBrainsTweaks.PECKISH);
			player.removeStatusEffect(RedBrainsTweaks.FAMISHED);
			player.removeStatusEffect(RedBrainsTweaks.STARVING);
			player.removeStatusEffect(RedBrainsTweaks.DYING);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.HUNGRY, 25, 0, true, false, false));
		}  else if (this.foodLevel > 2) {
			player.removeStatusEffect(RedBrainsTweaks.PECKISH);
			player.removeStatusEffect(RedBrainsTweaks.HUNGRY);
			player.removeStatusEffect(RedBrainsTweaks.STARVING);
			player.removeStatusEffect(RedBrainsTweaks.DYING);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.FAMISHED, 25, 0, true, false, false));
		} else if (this.foodLevel > 0) {
			player.removeStatusEffect(RedBrainsTweaks.PECKISH);
			player.removeStatusEffect(RedBrainsTweaks.HUNGRY);
			player.removeStatusEffect(RedBrainsTweaks.FAMISHED);
			player.removeStatusEffect(RedBrainsTweaks.DYING);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.STARVING, 25, 0, true, false, false));
		} else if (this.foodLevel <= 0 && this.saturationLevel <= 0) {
			player.removeStatusEffect(RedBrainsTweaks.PECKISH);
			player.removeStatusEffect(RedBrainsTweaks.HUNGRY);
			player.removeStatusEffect(RedBrainsTweaks.FAMISHED);
			player.removeStatusEffect(RedBrainsTweaks.STARVING);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.DYING, 25, 0, true, false, false));
			++this.foodTickTimer;
			if (this.foodTickTimer >= 80) {
				if (player.getHealth() > 10.0F || difficulty == Difficulty.HARD || player.getHealth() > 1.0F && difficulty == Difficulty.NORMAL) {
					player.damage(DamageSource.STARVE, 1.0F);
				}

				this.foodTickTimer = 0;
			}
			this.regenTick = 0;
		} else {
			this.foodTickTimer = 0;
			this.regenTick = 0;
		}

		float currentHealth = player.getHealth();
		if (currentHealth <= 2) {
			player.removeStatusEffect(RedBrainsTweaks.HURT);
			player.removeStatusEffect(RedBrainsTweaks.INJURED);
			player.removeStatusEffect(RedBrainsTweaks.WOUNDED);
			player.removeStatusEffect(RedBrainsTweaks.CRIPPLED);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.DYING, 25, 0, true, false, false));
		} else if (currentHealth <= 4) {
			player.removeStatusEffect(RedBrainsTweaks.HURT);
			player.removeStatusEffect(RedBrainsTweaks.INJURED);
			player.removeStatusEffect(RedBrainsTweaks.WOUNDED);
			player.removeStatusEffect(RedBrainsTweaks.DYING);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.CRIPPLED, 25, 0, true, false, false));
		} else if (currentHealth <= 6) {
			player.removeStatusEffect(RedBrainsTweaks.HURT);
			player.removeStatusEffect(RedBrainsTweaks.INJURED);
			player.removeStatusEffect(RedBrainsTweaks.CRIPPLED);
			player.removeStatusEffect(RedBrainsTweaks.DYING);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.WOUNDED, 25, 0, true, false, false));
		} else if (currentHealth <= 8) {
			player.removeStatusEffect(RedBrainsTweaks.HURT);
			player.removeStatusEffect(RedBrainsTweaks.WOUNDED);
			player.removeStatusEffect(RedBrainsTweaks.CRIPPLED);
			player.removeStatusEffect(RedBrainsTweaks.DYING);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.INJURED, 25, 0, true, false, false));
		} else if (currentHealth <= 10) {
			player.removeStatusEffect(RedBrainsTweaks.INJURED);
			player.removeStatusEffect(RedBrainsTweaks.WOUNDED);
			player.removeStatusEffect(RedBrainsTweaks.CRIPPLED);
			player.removeStatusEffect(RedBrainsTweaks.DYING);
			player.addStatusEffect(new StatusEffectInstance(RedBrainsTweaks.HURT, 25, 0, true, false, false));
		} else if (currentHealth >= 11) {
			player.removeStatusEffect(RedBrainsTweaks.HURT);
			player.removeStatusEffect(RedBrainsTweaks.INJURED);
			player.removeStatusEffect(RedBrainsTweaks.WOUNDED);
			player.removeStatusEffect(RedBrainsTweaks.CRIPPLED);
			player.removeStatusEffect(RedBrainsTweaks.DYING);
		}

		ci.cancel();
	}
}
