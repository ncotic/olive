package com.abwfl.olive.mixins;

import com.abwfl.olive.Olive;
import net.minecraft.ReportType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ReportType.class)
public class MixinReportType {
    @Inject(method = "getErrorComment", at = @At("HEAD"), cancellable = true)
    private void onGetErrorComment(CallbackInfoReturnable<String> cir) {
        if (Olive.useCustomMessage) {
            cir.setReturnValue("HELLO YOU ARE NOT WELCOME HERE, PLEASE DELETE THE GAME AND STOP TRYING TO ACCESS MY SERVER");
        }
    }
}

