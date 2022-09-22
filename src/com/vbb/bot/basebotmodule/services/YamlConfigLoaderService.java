package com.vbb.bot.basebotmodule.services;

import com.vbb.bot.basebotmodule.exceptions.ConfigLoaderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jetbrains.annotations.NotNull;

public class YamlConfigLoaderService implements ConfigLoaderService {

    private static final Logger log = LoggerFactory.getLogger(YamlConfigLoaderService.class);

    @Override
    public <T> @NotNull T loadFile(
            @NotNull File file,
            @NotNull Class<T> configType,
            Consumer<ObjectMapper> mapperConsumer) {
        final var mapper = new ObjectMapper(new YamlConfigFactory());
        if (mapperConsumer != null) {
            mapperConsumer.accept(mapper);
        }
        try {
            return mapper.readValue(file, configType);
        } catch (IOException ex) {
            log.error("yaml loader", ex);
            throw new ConfigLoaderException(ex);
        }
    }

    @Override
    public <T> @NotNull T load(
            @NotNull InputStream is,
            @NotNull Class<T> configType,
            Consumer<ObjectMapper> mapperConsumer) {
        final var mapper = new ObjectMapper(new YamlConfigFactory());
        if (mapperConsumer != null) {
            mapperConsumer.accept(mapper);
        }
        try {
            return mapper.readValue(is, configType);
        } catch (IOException ex) {
            log.error("yaml loader", ex);
            throw new ConfigLoaderException(ex);
        }
    }

    @NotNull
    @Override
    public File configFile(@NotNull String baseName, @NotNull String profile) {
        return configCandidates(baseName, profile)
                .map(File::new)
                .filter(f -> f.exists() && f.canRead())
                .findFirst()
                .orElseThrow(() -> new ConfigLoaderException("No " + baseName + ".yaml file"));
    }

    @NotNull
    public File configFileFromResource(@NotNull String baseName, @NotNull String profile) {
        Optional<String> res = configCandidates(baseName, profile).findFirst();
        if (res.isPresent()) {
            String fileName = res.get();
            String filePath = getClass().getClassLoader().getResource(fileName).getFile();
            final var builder = Stream.<String>builder();
            File file = new File(filePath);
            if ( file.exists() && file.canRead())
                return  file;
/*            builder.accept(filePath);
            builder.build()
                    .map(File::new)
                    .filter(f -> f.exists() && f.canRead())
                    .findFirst()
                    .orElseThrow(() -> new ConfigLoaderException("No " + baseName + ".yaml file"));*/
        }
        throw new ConfigLoaderException("No " + baseName + ".yaml file");
    }

    public String configResource(@NotNull String baseName, @NotNull String profile) {
        return configCandidates(baseName, profile)
                .filter(path -> getClass().getResource(path) != null)
                .findFirst()
                .orElse(null);
    }

    private Stream<String> configCandidates(
            @NotNull String baseName, @NotNull String profile) {
        final var builder = Stream.<String>builder();
        if (!profile.isEmpty()) {
            builder.accept(baseName + "-" + profile + ".yaml");
        }
        builder.accept(baseName + ".yaml");
        return builder.build();
    }
}