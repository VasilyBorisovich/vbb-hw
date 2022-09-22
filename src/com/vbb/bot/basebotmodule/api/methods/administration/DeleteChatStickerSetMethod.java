package com.vbb.bot.basebotmodule.api.methods.administration;

import com.vbb.bot.basebotmodule.api.methods.interfaces.ChatMethod;
import com.vbb.bot.basebotmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.DeleteChatStickerSet;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DeleteChatStickerSetMethod implements ChatMethod<DeleteChatStickerSetMethod, Boolean> {

    private final DeleteChatStickerSet method;

    public DeleteChatStickerSetMethod() {
        this(new DeleteChatStickerSet());
    }

    public DeleteChatStickerSetMethod(@NotNull DeleteChatStickerSet method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public DeleteChatStickerSetMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Boolean> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
