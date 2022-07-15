package com.github.theredbrain.redbrainstweaks.client.render.block.entity;

import com.github.theredbrain.redbrainstweaks.block.entity.PlacedToolEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.*;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;

public class PlacedToolRenderer implements BlockEntityRenderer<PlacedToolEntity> {

    public PlacedToolRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(PlacedToolEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (!blockEntity.isEmpty() && blockEntity.getWorld() != null) {
            BlockState blockState = blockEntity.getWorld().getBlockState(blockEntity.getPos());
            if (!blockState.isAir()) {
                Direction blockDirection = blockState.get(HorizontalFacingBlock.FACING);
                matrices.push();
                if (blockEntity.getStack(0).getItem() instanceof AxeItem) {
                    if (blockDirection == Direction.NORTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.4D, 0.55D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((180F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((320F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    } else if (blockDirection == Direction.SOUTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.4D, 0.45D);
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((320F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    } else if (blockDirection == Direction.EAST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.45D, 0.4D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((90F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((320F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    } else if (blockDirection == Direction.WEST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.55D, 0.4D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((320F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    }
                } else if (blockEntity.getStack(0).getItem() instanceof HoeItem) {
                    if (blockDirection == Direction.NORTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.4D, 0.55D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((180F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((335F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    } else if (blockDirection == Direction.SOUTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.4D, 0.45D);
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((335F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    } else if (blockDirection == Direction.EAST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.45D, 0.4D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((90F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((335F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    } else if (blockDirection == Direction.WEST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.55D, 0.4D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((335F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    }
                } else if (blockEntity.getStack(0).getItem() instanceof PickaxeItem) {
                    if (blockDirection == Direction.NORTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.4D, 0.55D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((180F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((335F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    } else if (blockDirection == Direction.SOUTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.4D, 0.45D);
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((335F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    } else if (blockDirection == Direction.EAST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.45D, 0.4D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((90F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((335F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    } else if (blockDirection == Direction.WEST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.55D, 0.4D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((335F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((180F)));
                    }
                } else if (blockEntity.getStack(0).getItem() instanceof ShovelItem) {
                    if (blockDirection == Direction.NORTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.325D, 0.3D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((180F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((350F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((90F)));
                    } else if (blockDirection == Direction.SOUTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.675D, 0.275D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((350F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((90F)));
                    } else if (blockDirection == Direction.EAST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.25D, 0.325D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((90F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((350F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((90F)));
                    } else if (blockDirection == Direction.WEST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.225D, 0.675D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((350F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((90F)));
                    }
                } else if (blockEntity.getStack(0).getItem() instanceof SwordItem) {
                    if (blockDirection == Direction.NORTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.25D, 0.3D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((180F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((350F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((90F)));
                    } else if (blockDirection == Direction.SOUTH) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.75D, 0.3D, 0.5D);
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((350F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((90F)));
                    } else if (blockDirection == Direction.EAST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.3D, 0.25D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((90F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((350F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((90F)));
                    } else if (blockDirection == Direction.WEST) {
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0.5D, 0.3D, 0.75D);
                        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((350F)));
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion((270F)));
                        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((90F)));
                    }
                }
                MinecraftClient.getInstance().getItemRenderer().renderItem(blockEntity.getStack(0), ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND, light, overlay, matrices, vertexConsumers,
                        (int) blockEntity.getPos().asLong());
                matrices.pop();
            }
        }
    }
}
