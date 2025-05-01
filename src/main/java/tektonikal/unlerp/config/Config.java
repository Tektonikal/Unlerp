package tektonikal.unlerp.config;

import eu.midnightdust.lib.config.MidnightConfig;
import org.spongepowered.asm.mixin.Mixin;
import tektonikal.unlerp.Easings;


public class Config extends MidnightConfig {
    @Entry(name = "Mod Enabled") public static boolean enabled = true;
    @Entry(name = "Lerp Fuckery") public static boolean lerpFuckery = true;
    @Entry(name = "Lerp Easing") public static Easings lerpEasing = Easings.HALF;
    @Entry(name = "TickDelta Fuckery")public static boolean tickDeltaFuckery = true;
    @Entry(name = "TickDelta Easing") public static Easings tickDeltaEasing = Easings.HALF;
}
