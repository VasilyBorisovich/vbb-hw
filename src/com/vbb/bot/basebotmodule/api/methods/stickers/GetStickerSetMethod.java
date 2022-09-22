package com.vbb.bot.basebotmodule.api.methods.stickers;

import com.vbb.bot.basebotmodule.api.methods.interfaces.Method;
import com.vbb.bot.basebotmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.GetStickerSet;
import org.telegram.telegrambots.meta.api.objects.stickers.StickerSet;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetStickerSetMethod implements Method<StickerSet> {

    private final GetStickerSet method;

    public GetStickerSetMethod() {
        this(new GetStickerSet());
    }

    public GetStickerSetMethod(@NotNull GetStickerSet method) {
        this.method = method;
    }

    public String getName() {
        return method.getName();
    }

    public GetStickerSetMethod setName(@NotNull String name) {
        method.setName(name);
        return this;
    }

    @Override
    public StickerSet call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super StickerSet> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
