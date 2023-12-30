package net.fadiese.sinstatues;

import com.mojang.logging.LogUtils;
import net.fadiese.sinstatues.registry.SinStatuesBlockEntities;
import net.fadiese.sinstatues.registry.SinStatuesBlocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SinStatues.MOD_ID)
public class SinStatues
{
    public static final String MOD_ID = "sin_statues";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SinStatues() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SinStatuesBlocks.register(modEventBus);
        SinStatuesBlockEntities.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
