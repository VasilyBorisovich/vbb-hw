package com.vbb.bot.basebotmodule.api.methods.answerqueries;

import com.vbb.bot.basebotmodule.api.methods.interfaces.Method;
import com.vbb.bot.basebotmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.AnswerPreCheckoutQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AnswerPreCheckoutQueryMethod implements Method<Boolean> {

    private final AnswerPreCheckoutQuery method;

    public AnswerPreCheckoutQueryMethod() {
        this(new AnswerPreCheckoutQuery());
    }

    public AnswerPreCheckoutQueryMethod(@NotNull AnswerPreCheckoutQuery method) {
        this.method = method;
    }

    public String getPreCheckoutQueryId() {
        return method.getPreCheckoutQueryId();
    }

    public AnswerPreCheckoutQueryMethod setPreCheckoutQueryId(@NotNull String preCheckoutQueryId) {
        method.setPreCheckoutQueryId(preCheckoutQueryId);
        return this;
    }

    public boolean getOk() {
        return method.getOk();
    }

    public AnswerPreCheckoutQueryMethod setOk(boolean isPersonal) {
        method.setOk(isPersonal);
        return this;
    }

    public String getErrorMessage() {
        return method.getErrorMessage();
    }

    public AnswerPreCheckoutQueryMethod setErrorMessage(String errorMessage) {
        method.setErrorMessage(errorMessage);
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