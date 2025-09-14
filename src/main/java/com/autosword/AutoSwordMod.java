package com.autosword;

import com.autosword.config.AutoSwordConfig;
import com.autosword.handlers.AutoAttackHandler;
import com.autosword.keybinds.KeyBindings;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(AutoSwordMod.MODID)
public class AutoSwordMod {
    public static final String MODID = "autosword";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AutoSwordMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, AutoSwordConfig.SPEC);

        // Register the setup method for modloading
        modEventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(AutoAttackHandler.class);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // Register keybinds
        KeyBindings.register();
        
        LOGGER.info("AutoSword mod initialized successfully!");
    }
}
