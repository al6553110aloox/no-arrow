package net.custom.mod.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractArrow.class)
public class ArrowMixin {
    @Inject(method = "onHitEntity", at = @At("HEAD"))
    private void onArrowHit(EntityHitResult entityHitResult, CallbackInfo ci) {
        Entity target = entityHitResult.getEntity();
        if (target instanceof LivingEntity livingTarget) {
            livingTarget.invulnerableTime = 0;
        }
    }
}
