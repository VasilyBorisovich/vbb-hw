package com.vbb.bot.basebotmodule.exceptions;

public class ConfigLoaderException extends RuntimeException {

    public ConfigLoaderException(Throwable cause) {
        super(cause);
    }

    public ConfigLoaderException(String message) {
        super(message);
    }
}