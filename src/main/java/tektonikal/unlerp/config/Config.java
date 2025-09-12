package tektonikal.unlerp.config;

import eu.midnightdust.lib.config.MidnightConfig;
import org.spongepowered.asm.mixin.Mixin;
import tektonikal.unlerp.Easings;


public class Config extends MidnightConfig {
    @Entry(name = "Mod Enabled") public static boolean enabled = true;
    @Entry(name = "Lerp Fuckery") public static boolean lerpFuckery = false;
    @Entry(name = "Lerp Easing") public static Easings lerpEasing = Easings.HALF;
    @Entry(name = "TickDelta Fuckery")public static boolean tickDeltaFuckery = false;
    @Entry(name = "TickDelta Easing") public static Easings tickDeltaEasing = Easings.HALF;
    @Entry(name = "Entity Interpolation Fuckery") public static boolean entityInterpolationFuckery = true;
    @Entry(name = "Entity Interpolation Steps") public static int entityInterpolationSteps = 1;
    @Entry(name = "Extra Evil Option For Those Who Know") public static boolean endermiteOnly = true;
}
