package net.fadiese.sinstatues.blockentity;

import net.fadiese.sinstatues.registry.SinStatuesBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SinStatueBlockEntity extends BlockEntity {
    public MobEffect effect;
    public int effectPower = 0;
    private int counter = 0;

    public SinStatueBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(SinStatuesBlockEntities.SIN_STATUE_ENTITY.get(), pPos, pBlockState);
    }

    public void setEffect(MobEffect effect) {
        this.effect = effect;
    }

    public void setPower(int power) {
        this.effectPower = power;
    }

    public static <T extends BlockEntity> void serverTick(Level level, BlockPos blockPos, BlockState blockState, SinStatueBlockEntity sinStatueBlockEntity) {
        if (sinStatueBlockEntity.effect != null && sinStatueBlockEntity.counter == 0) {
            AABB aabb = (new AABB(blockPos)).inflate(10).expandTowards(0.0D, level.getHeight(), 0.0D);
            List<Player> list = level.getEntitiesOfClass(Player.class, aabb);
            for (Player player : list) {
                player.addEffect(new MobEffectInstance(sinStatueBlockEntity.effect, 120, sinStatueBlockEntity.effectPower, true, true));
            }
        }
        sinStatueBlockEntity.counter++;
        if (sinStatueBlockEntity.counter == 100) {
            sinStatueBlockEntity.counter = 0;
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.putInt("effect_power", effectPower);
        if (effect != null) {
            pTag.put("effect", ResourceLocation.CODEC.encodeStart(NbtOps.INSTANCE, Registry.MOB_EFFECT.getKey(effect)).result().get());
        }

    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        effectPower = pTag.getInt("effect_power");
        if (pTag.contains("effect")) {
            effect = Registry.MOB_EFFECT.get(ResourceLocation.CODEC.parse(NbtOps.INSTANCE, pTag.get("effect")).result().get());
        }
    }

}
