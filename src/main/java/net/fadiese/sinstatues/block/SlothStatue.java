package net.fadiese.sinstatues.block;

import net.fadiese.sinstatues.blockentity.SinStatueBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SlothStatue extends AbstractSinStatue{

    private final VoxelShape SHAPE_NORTH_SOUTH = Block.box(0, 0, 4, 16, 7, 12);
    private final VoxelShape SHAPE_EAST_WEST = Block.box(4, 0, 0, 12, 7, 16);

    public SlothStatue(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        SinStatueBlockEntity entity = new SinStatueBlockEntity(pPos, pState);
        entity.setEffect(MobEffects.MOVEMENT_SLOWDOWN);
        entity.setPower(1);
        return entity;
    }

    @Override
    public VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        if (Direction.NORTH.equals(pState.getValue(FACING)) || Direction.SOUTH.equals(pState.getValue(FACING))) {
            return SHAPE_NORTH_SOUTH;
        } else {
            return SHAPE_EAST_WEST;
        }
    }

}
