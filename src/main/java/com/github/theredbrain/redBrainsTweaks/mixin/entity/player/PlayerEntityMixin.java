package com.github.theredbrain.redBrainsTweaks.mixin.entity.player;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

//    @Shadow
//    public void incrementStat(Identifier stat) {
//        throw new AssertionError();
//    }

//    @Shadow
//    public void increaseStat(Identifier stat, int amount) {
//        throw new AssertionError();
//    }
//
//    @Shadow
//    public void incrementStat(Stat<?> stat) {
//        throw new AssertionError();
//    }
//
//    @Shadow
//    public void increaseStat(Stat<?> stat, int amount) {
//        throw new AssertionError();
//    }

//    @Shadow
//    public void addExhaustion(float exhaustion) {
//        throw new AssertionError();
//    }

//    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
//        super(entityType, world);
//    }

    @Inject(at = @At("RETURN"),
            method = "canFoodHeal",
            cancellable = true)
    private void hardcoreHealing(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    //TODO attacking adds more exhaustion?
    // vanilla 0.1

//    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
//    public void jump(CallbackInfo ci) {
//        super.jump();
//        this.incrementStat(Stats.JUMP);
//        if (this.isSprinting()) {
//            this.addExhaustion(1.0F); // TODO playtesting
//        } else {
//            this.addExhaustion(0.5F); // TODO playtesting
//        }
//
//    }
}
