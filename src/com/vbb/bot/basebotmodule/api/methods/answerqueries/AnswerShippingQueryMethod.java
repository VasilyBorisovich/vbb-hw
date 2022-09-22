package com.vbb.bot.basebotmodule.api.methods.answerqueries;

import com.vbb.bot.basebotmodule.api.methods.interfaces.Method;
import com.vbb.bot.basebotmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.AnswerShippingQuery;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingOption;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AnswerShippingQueryMethod implements Method<Boolean> {

    private final AnswerShippingQuery method;

    public AnswerShippingQueryMethod() {
        this(new AnswerShippingQuery());
    }

    public AnswerShippingQueryMethod(@NotNull AnswerShippingQuery method) {
        this.method = method;
    }

    public String getShippingQueryId() {
        return method.getShippingQueryId();
    }

    public AnswerShippingQueryMethod setShippingQueryId(@NotNull String shippingQueryId) {
        method.setShippingQueryId(shippingQueryId);
        return this;
    }

    public List<ShippingOption> getShippingOptions() {
        return method.getShippingOptions();
    }

    public AnswerShippingQueryMethod setShippingOptions(List<ShippingOption> shippingOptions) {
        method.setShippingOptions(shippingOptions);
        return this;
    }

    public boolean getOk() {
        return Boolean.TRUE.equals(method.getOk());
    }

    public AnswerShippingQueryMethod setOk(boolean isPersonal) {
        method.setOk(isPersonal);
        return this;
    }

    public String getErrorMessage() {
        return method.getErrorMessage();
    }

    public AnswerShippingQueryMethod setErrorMessage(String errorMessage) {
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