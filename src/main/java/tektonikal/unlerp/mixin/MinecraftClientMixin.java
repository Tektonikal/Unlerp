package tektonikal.unlerp.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderTickCounter;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tektonikal.unlerp.config.Config;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

    @Redirect(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/RenderTickCounter;tickDelta:F", opcode = Opcodes.GETFIELD))
    private float injected(RenderTickCounter instance) {
        if (Config.tickDeltaFuckery && Config.enabled) {
            return Config.tickDeltaEasing.getFunction().apply((double) instance.tickDelta).floatValue();
        }
        return instance.tickDelta;
    }
}
