package com.vbb.bot;

import java.io.File;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.vbb.bot.basebotmodule.BotHandler;
import com.vbb.bot.basebotmodule.BotModule;
import com.vbb.bot.basebotmodule.Runner;
import com.vbb.bot.basebotmodule.beans.Config;
import com.vbb.bot.basebotmodule.services.YamlConfigLoaderService;

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
        final YamlConfigLoaderService configLoader = new YamlConfigLoaderService();
        final File configFile = configLoader.configFileFromResource("iotbot", config.getProfile());
        final var botConfig = configLoader.loadFile(configFile, IotBotConfig.class);
        return new IotBotHandler(botConfig);
    }

}
