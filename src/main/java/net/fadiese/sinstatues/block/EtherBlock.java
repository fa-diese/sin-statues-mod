package net.fadiese.sinstatues.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class EtherBlock extends Block {
    public EtherBlock(Properties pProperties) {
        super(pProperties);
    }

    public void stepOn(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @NotNull Entity pEntity) {
        if (pEntity instanceof LivingEntity) {
            pEntity.hurt(DamageSource.MAGIC, 2.0F);
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
