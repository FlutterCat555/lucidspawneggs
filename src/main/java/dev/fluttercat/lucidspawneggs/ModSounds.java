package dev.fluttercat.lucidspawneggs;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    public static final SoundEvent THROW = registerSoundEvent("throw");
    public static final SoundEvent POP = registerSoundEvent("pop");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(LucidSpawneggs.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSounds() {
        LucidSpawneggs.LOGGER.info("Registering Mod Sounds for " + LucidSpawneggs.MOD_ID);
    }
}
