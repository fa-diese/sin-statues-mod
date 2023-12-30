package net.fadiese.sinstatues.itemgroup;

import net.fadiese.sinstatues.registry.SinStatuesBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class SinStatuesItemGroup extends CreativeModeTab {
    public static SinStatuesItemGroup SIN_STATUES_GROUP = new SinStatuesItemGroup("sin_statues_tab");

    public SinStatuesItemGroup(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(SinStatuesBlocks.WRATH_STATUE.get());
    }
}
