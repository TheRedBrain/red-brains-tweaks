package com.github.theredbrain.redBrainsTweaks.mixin.entity.passive;

//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.ai.goal.TemptGoal;
//import net.minecraft.entity.passive.AnimalEntity;
//import net.minecraft.entity.passive.CowEntity;
//import net.minecraft.item.ItemConvertible;
//import net.minecraft.item.Items;
//import net.minecraft.recipe.Ingredient;
//import net.minecraft.world.World;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(CowEntity.class)
//public abstract class CowEntityMixin extends AnimalEntity {
//    protected CowEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    @Inject(at = @At("TAIL"), method = "initGoals")
//    protected void temptedByGrassGoal(CallbackInfo ci) {
//        this.goalSelector.add(3, new TemptGoal(this, 1.1D, Ingredient.ofItems(new ItemConvertible[]{Items.GRASS}), false));
//        this.goalSelector.add(3, new TemptGoal(this, 1.1D, Ingredient.ofItems(new ItemConvertible[]{Items.TALL_GRASS}), false));
//    }
//}
