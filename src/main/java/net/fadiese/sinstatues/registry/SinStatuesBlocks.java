package net.fadiese.sinstatues.registry;

import net.fadiese.sinstatues.SinStatues;
import net.fadiese.sinstatues.block.*;
import net.fadiese.sinstatues.itemgroup.SinStatuesItemGroup;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SinStatuesBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SinStatues.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SinStatues.MOD_ID);

    public static final RegistryObject<Block> ENVY_STATUE = registerBlock("envy_statue", () -> new EnvyStatue(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE).noOcclusion()), new Item.Properties().tab(SinStatuesItemGroup.SIN_STATUES_GROUP).rarity(Rarity.EPIC));
    public static final RegistryObject<Block> GLUTTONY_STATUE = registerBlock("gluttony_statue", () -> new GluttonyStatue(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE).noOcclusion()), new Item.Properties().tab(SinStatuesItemGroup.SIN_STATUES_GROUP).rarity(Rarity.EPIC));
    public static final RegistryObject<Block> GREED_STATUE = registerBlock("greed_statue", () -> new GreedStatue(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE).noOcclusion()), new Item.Properties().tab(SinStatuesItemGroup.SIN_STATUES_GROUP).rarity(Rarity.EPIC));
    public static final RegistryObject<Block> LUST_STATUE = registerBlock("lust_statue", () -> new LustStatue(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE).noOcclusion()), new Item.Properties().tab(SinStatuesItemGroup.SIN_STATUES_GROUP).rarity(Rarity.EPIC));
    public static final RegistryObject<Block> PRIDE_STATUE = registerBlock("pride_statue", () -> new PrideStatue(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE).noOcclusion()), new Item.Properties().tab(SinStatuesItemGroup.SIN_STATUES_GROUP).rarity(Rarity.EPIC));
    public static final RegistryObject<Block> SLOTH_STATUE = registerBlock("sloth_statue", () -> new SlothStatue(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE).noOcclusion()), new Item.Properties().tab(SinStatuesItemGroup.SIN_STATUES_GROUP).rarity(Rarity.EPIC));
    public static final RegistryObject<Block> WRATH_STATUE = registerBlock("wrath_statue", () -> new WrathStatue(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.5F).sound(SoundType.STONE).noOcclusion()), new Item.Properties().tab(SinStatuesItemGroup.SIN_STATUES_GROUP).rarity(Rarity.EPIC));

    public static final RegistryObject<Block> ETHER_BLOCK = registerBlock("ether_block", () -> new EtherBlock(BlockBehaviour.Properties.of(Material.SAND).strength(1).sound(SoundType.SAND).lightLevel((blockstate) -> 15)), new Item.Properties().tab(SinStatuesItemGroup.SIN_STATUES_GROUP));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties properties) {
        RegistryObject<T> result = BLOCKS.register(name, block);
        registerBlockItem(name, result, properties);
        return result;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Item.Properties properties) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
