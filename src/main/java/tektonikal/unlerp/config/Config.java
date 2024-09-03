package tektonikal.unlerp.config;

import eu.midnightdust.lib.config.MidnightConfig;
import tektonikal.unlerp.Easings;


public class Config extends MidnightConfig {
    @Entry(name = "Mode") public static Easings easing = Easings.HALF;
}
