package com.autosword.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import com.autosword.AutoSwordMod;

@Mod.EventBusSubscriber(modid = AutoSwordMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AutoSwordConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue ENABLED = BUILDER
            .comment("Enable/disable auto sword attack")
            .define("enabled", false);

    private static final ModConfigSpec.IntValue ATTACK_INTERVAL = BUILDER
            .comment("Attack interval in milliseconds (default: 600ms for sword)")
            .defineInRange("attackInterval", 600, 100, 2000);

    private static final ModConfigSpec.BooleanValue WORK_IN_MENUS = BUILDER
            .comment("Continue attacking when in menus or alt-tabbed")
            .define("workInMenus", true);

    private static final ModConfigSpec.BooleanValue ONLY_SWORDS = BUILDER
            .comment("Only auto-attack when holding a sword")
            .define("onlySwords", true);

    private static final ModConfigSpec.BooleanValue REQUIRE_TARGET = BUILDER
            .comment("Only attack when there's a valid target")
            .define("requireTarget", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean enabled;
    public static int attackInterval;
    public static boolean workInMenus;
    public static boolean onlySwords;
    public static boolean requireTarget;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        enabled = ENABLED.get();
        attackInterval = ATTACK_INTERVAL.get();
        workInMenus = WORK_IN_MENUS.get();
        onlySwords = ONLY_SWORDS.get();
        requireTarget = REQUIRE_TARGET.get();
    }
}
