package tektonikal.unlerp;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tektonikal.unlerp.config.Config;

import java.util.Objects;

import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;

public class Unlerp implements ClientModInitializer {
    private static boolean openConfig = false;

    @Override
    public void onInitializeClient() {
        MidnightConfig.init("unlerp", Config.class);
        ClientCommandRegistrationCallback.EVENT.register(
                (dispatcher, registryAccess) -> dispatcher.register(
                        ClientCommandManager.literal("unlerp")
                                .executes(
                                        context -> {
                                            openConfig = true;
                                            return 1;
                                        }
                                )
                )
        );
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (openConfig) {
                openConfig = false;
                MinecraftClient.getInstance().setScreen(Config.getScreen(client.currentScreen, "unlerp"));
            }
        });
    }
}