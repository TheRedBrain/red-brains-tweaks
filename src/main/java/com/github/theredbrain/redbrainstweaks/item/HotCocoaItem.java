package com.github.theredbrain.redbrainstweaks.item;

import com.github.theredbrain.redbrainstweaks.RedBrainsTweaks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HotCocoaItem extends MilkBottleItem {

    public HotCocoaItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void affectConsumer(ItemStack stack, World world, LivingEntity user) {
        Set<StatusEffect> compatibleEffectList = user.getStatusEffects().stream().filter(this::canEffectInstanceBeRemovedByMilk).map(
                StatusEffectInstance::getEffectType).collect(Collectors.toSet());

        if (!compatibleEffectList.isEmpty()) {
            compatibleEffectList.stream().skip(world.getRandom().nextInt(compatibleEffectList.size())).findFirst().ifPresent(
                    user::removeStatusEffect);
        }
    }

    private boolean canEffectInstanceBeRemovedByMilk(StatusEffectInstance effectInstance) {
        return effectInstance.getEffectType().getCategory() == StatusEffectCategory.HARMFUL;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(RedBrainsTweaks.i18n("tooltip.hot_cocoa").formatted(Formatting.BLUE));
    }
}