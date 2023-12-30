package net.fadiese.sinstatues.registry;

import net.fadiese.sinstatues.SinStatues;
import net.fadiese.sinstatues.blockentity.SinStatueBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SinStatuesBlockEntities {
    private static Block[] statues() {
        return new Block[]{
                SinStatuesBlocks.ENVY_STATUE.get(),
                SinStatuesBlocks.GLUTTONY_STATUE.get(),
                SinStatuesBlocks.GREED_STATUE.get(),
                SinStatuesBlocks.LUST_STATUE.get(),
                SinStatuesBlocks.PRIDE_STATUE.get(),
                SinStatuesBlocks.SLOTH_STATUE.get(),
                SinStatuesBlocks.WRATH_STATUE.get()
        };
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SinStatues.MOD_ID);
    public static final RegistryObject<BlockEntityType<SinStatueBlockEntity>> SIN_STATUE_ENTITY = BLOCK_ENTITIES.register("sin_statue", () -> BlockEntityType.Builder.of(SinStatueBlockEntity::new, statues()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
