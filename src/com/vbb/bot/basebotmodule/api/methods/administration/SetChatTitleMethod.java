package com.vbb.bot.basebotmodule.api.methods.administration;

import com.vbb.bot.basebotmodule.api.methods.interfaces.ChatMethod;
import com.vbb.bot.basebotmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatTitle;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetChatTitleMethod implements ChatMethod<SetChatTitleMethod, Boolean> {

    private final SetChatTitle method;

    public SetChatTitleMethod() {
        this(new SetChatTitle());
    }

    public SetChatTitleMethod(@NotNull SetChatTitle method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SetChatTitleMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public String getTitle() {
        return method.getTitle();
    }

    public SetChatTitleMethod setTitle(@NotNull String title) {
        method.setTitle(title);
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
