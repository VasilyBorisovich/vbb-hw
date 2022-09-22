package com.vbb.bot.basebotmodule.api.methods.administration;

import com.vbb.bot.basebotmodule.api.methods.interfaces.ChatMessageMethod;
import com.vbb.bot.basebotmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.pinnedmessages.UnpinChatMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UnpinChatMessageMethod implements ChatMessageMethod<UnpinChatMessageMethod, Boolean> {

    private final UnpinChatMessage method;

    public UnpinChatMessageMethod() {
        this(new UnpinChatMessage());
    }

    public UnpinChatMessageMethod(@NotNull UnpinChatMessage method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public UnpinChatMessageMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.getMessageId();
    }

    @Override
    public UnpinChatMessageMethod setMessageId(Integer messageId) {
        method.setMessageId(messageId);
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
