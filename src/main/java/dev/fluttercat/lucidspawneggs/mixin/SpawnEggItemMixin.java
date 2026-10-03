package dev.fluttercat.lucidspawneggs.mixin;

import dev.fluttercat.lucidspawneggs.LucidSpawneggsConfig;
import dev.fluttercat.lucidspawneggs.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpawnEggItem.class)
public abstract class SpawnEggItemMixin {

    @Inject(at = @At("HEAD"), method = "spawnMob")
    private static void spawnMob(EntityType<?> type, @Nullable LivingEntity user, ItemStack itemStack, ServerLevel level, BlockPos spawnPos, boolean tryMoveDown, boolean movedUp, CallbackInfoReturnable<InteractionResult> cir) {
        if (LucidSpawneggsConfig.popSound) {
            level.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.THROW, SoundSource.PLAYERS);
        }
        if (LucidSpawneggsConfig.throwSound) {
            level.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.POP, SoundSource.PLAYERS);
        }
    }
}