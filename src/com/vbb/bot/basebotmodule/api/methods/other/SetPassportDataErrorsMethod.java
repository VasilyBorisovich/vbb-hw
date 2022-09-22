package com.vbb.bot.basebotmodule.api.methods.other;

import com.vbb.bot.basebotmodule.api.methods.interfaces.UserMethod;
import com.vbb.bot.basebotmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.SetPassportDataErrors;
import org.telegram.telegrambots.meta.api.objects.passport.dataerror.PassportElementError;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetPassportDataErrorsMethod implements UserMethod<SetPassportDataErrorsMethod, Boolean> {

    private final SetPassportDataErrors method;

    public SetPassportDataErrorsMethod() {
        this(new SetPassportDataErrors());
    }

    public SetPassportDataErrorsMethod(@NotNull SetPassportDataErrors method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public SetPassportDataErrorsMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    public List<PassportElementError> getErrors() {
        return method.getErrors();
    }

    public SetPassportDataErrorsMethod setErrors(@NotNull List<PassportElementError> errors) {
        method.setErrors(errors);
        return this;
    }

    public SetPassportDataErrorsMethod addError(@NotNull PassportElementError error) {
        var errors = method.getErrors();
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(error);
        method.setErrors(errors);
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
