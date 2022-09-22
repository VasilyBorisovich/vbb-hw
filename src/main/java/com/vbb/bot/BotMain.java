package com.vbb.bot;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.BotModule;
import com.annimon.tgbotsmodule.Runner;
import com.annimon.tgbotsmodule.beans.Config;
import com.annimon.tgbotsmodule.services.YamlConfigLoaderService;

@Slf4j
public class BotMain implements BotModule {
    public static void main(String[] args) {
        final var profile = (args.length >= 1 && !args[0].isEmpty()) ? args[0] : "";
        BotMain botMain = new BotMain();
        log.info("BotMain started, point {}", profile);
        botMain.initBots();
        Runner.run(profile, List.of(botMain));
    }

    private void initBots() {
    }

    @Override
    public @org.jetbrains.annotations.NotNull BotHandler botHandler(@org.jetbrains.annotations.NotNull Config config) {
        final var configLoader = new YamlConfigLoaderService();
        final var configFile = configLoader.configFile("iotbot", config.getProfile());
        final var botConfig = configLoader.loadFile(configFile, IotBotConfig.class);
        return new IotBotHandler(botConfig);
    }

}
