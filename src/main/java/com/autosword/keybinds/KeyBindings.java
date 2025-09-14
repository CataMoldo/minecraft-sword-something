package com.autosword.keybinds;

import com.autosword.AutoSwordMod;
import com.autosword.config.AutoSwordConfig;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = AutoSwordMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyBindings {
    public static final KeyMapping TOGGLE_AUTO_ATTACK = new KeyMapping(
            "key.autosword.toggle_auto_attack",
            GLFW.GLFW_KEY_F6,
            "key.categories.autosword"
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_AUTO_ATTACK);
    }
}
