package net.fadiese.sinstatues.block;

import net.fadiese.sinstatues.blockentity.SinStatueBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PrideStatue extends AbstractSinStatue{
    public PrideStatue(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        SinStatueBlockEntity entity = new SinStatueBlockEntity(pPos, pState);
        entity.setEffect(MobEffects.DAMAGE_RESISTANCE);
        entity.setPower(1);
        return entity;
    }

}
