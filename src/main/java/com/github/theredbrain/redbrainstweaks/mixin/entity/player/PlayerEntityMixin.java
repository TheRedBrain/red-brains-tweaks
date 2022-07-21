package com.github.theredbrain.redbrainstweaks.mixin.entity.player;

import com.github.theredbrain.redbrainstweaks.block.entity.RespawnAnchorBlockMixinDuck;
import com.github.theredbrain.redbrainstweaks.enchantment.BackstabbingEnchantment;
import com.github.theredbrain.redbrainstweaks.registry.EnchantmentsRegistry;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow
    protected HungerManager hungerManager;

    @Shadow
    @Final
    private PlayerAbilities abilities;

    @Inject(method = "canConsume", at = @At("HEAD"), cancellable = true)
    public void canConsume(boolean ignoreHunger, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue((this.abilities.invulnerable || ignoreHunger || this.hungerManager.isNotFull()) && !this.hasStatusEffect(StatusEffects.HUNGER));
    }

//    @Inject(at = @At("RETURN"), method = "canFoodHeal", cancellable = true)
//    private void hardcoreHealing(CallbackInfoReturnable<Boolean> cir) {
//        cir.setReturnValue(false);
//    }

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

    @Inject(method = "findRespawnPosition", at = @At("HEAD"), cancellable = true)
    private static void checkIfRespawnAnchorHasPyramid(ServerWorld world, BlockPos pos, float angle, boolean forced, boolean alive, CallbackInfoReturnable<Optional<Vec3d>> cir) {
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if (block instanceof RespawnAnchorBlock && (Integer)blockState.get(RespawnAnchorBlock.CHARGES) > 0 /*&& RespawnAnchorBlock.isNether(world) */&& ((RespawnAnchorBlockMixinDuck)block).isStillValid(world, pos)) {
            Optional<Vec3d> optional = RespawnAnchorBlock.findRespawnPosition(EntityType.PLAYER, world, pos);
            if (!alive && optional.isPresent()) {
                world.setBlockState(pos, (BlockState)blockState.with(RespawnAnchorBlock.CHARGES, (Integer)blockState.get(RespawnAnchorBlock.CHARGES) - 1), 3);
            }

            cir.setReturnValue(optional);
        } else if (block instanceof BedBlock && BedBlock.isBedWorking(world)) {
            cir.setReturnValue(BedBlock.findWakeUpPosition(EntityType.PLAYER, world, pos, angle));
        } else if (!forced) {
            cir.setReturnValue(Optional.empty());
        } else {
            boolean bl = block.canMobSpawnInside();
            boolean bl2 = world.getBlockState(pos.up()).getBlock().canMobSpawnInside();
            cir.setReturnValue(bl && bl2 ? Optional.of(new Vec3d((double)pos.getX() + 0.5D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D)) : Optional.empty());
        }
    }
}
