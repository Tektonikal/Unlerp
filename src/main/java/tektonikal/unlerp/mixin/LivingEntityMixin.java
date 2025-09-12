package tektonikal.unlerp.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tektonikal.unlerp.config.Config;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    protected int bodyTrackingIncrements;

    @Shadow
    protected int headTrackingIncrements;


    @Inject(method = "updateTrackedPositionAndAngles", at = @At(value = "TAIL"))
    private void init(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate, CallbackInfo ci) {
        if (Config.enabled && Config.entityInterpolationFuckery) {
            //If you know you know
            if (Config.endermiteOnly) {
                if (((LivingEntity) (Object) this) instanceof EndermiteEntity) {
                    bodyTrackingIncrements = Config.entityInterpolationSteps;

                }
            } else {
                bodyTrackingIncrements = Config.entityInterpolationSteps;
            }
        }
    }

    @Inject(method = "updateTrackedHeadRotation", at = @At(value = "TAIL"))
    private void init(float yaw, int interpolationSteps, CallbackInfo ci) {
        if (Config.enabled && Config.entityInterpolationFuckery) {
            if (Config.endermiteOnly) {
                if (((LivingEntity) (Object) this) instanceof EndermiteEntity) {
                    headTrackingIncrements = Config.entityInterpolationSteps;

                }
            } else {
                headTrackingIncrements = Config.entityInterpolationSteps;
            }
        }
    }
}
