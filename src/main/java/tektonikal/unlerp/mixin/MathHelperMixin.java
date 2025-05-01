package tektonikal.unlerp.mixin;

import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tektonikal.unlerp.config.Config;

import static net.minecraft.util.math.MathHelper.floor;

@Mixin(MathHelper.class)
public abstract class MathHelperMixin {
    @Inject(method = "lerp(FII)I", at = @At(value = "HEAD"), cancellable = true)
    private static void unlerp(float delta, int start, int end, CallbackInfoReturnable<Integer> cir) {
        if (Config.enabled && Config.lerpFuckery) {
            cir.setReturnValue(start + floor(Config.lerpEasing.getFunction().apply((double) delta).floatValue() * (float) (end - start)));
        }
    }

    @Inject(method = "lerp(FFF)F", at = @At(value = "HEAD"), cancellable = true)
    private static void unlerp(float delta, float start, float end, CallbackInfoReturnable<Float> cir) {
        if (Config.enabled && Config.lerpFuckery) {
            cir.setReturnValue(start + Config.lerpEasing.getFunction().apply((double) delta).floatValue() * (end - start));
        }
    }

    @Inject(method = "lerp(DDD)D", at = @At(value = "HEAD"), cancellable = true)
    private static void unlerp(double delta, double start, double end, CallbackInfoReturnable<Double> cir) {
        if (Config.enabled && Config.lerpFuckery) {
            cir.setReturnValue(start + Config.lerpEasing.getFunction().apply(delta).floatValue() * (end - start));
        }
    }
}