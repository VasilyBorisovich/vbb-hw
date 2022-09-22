package com.vbb.bot.basebotmodule.api.methods.updates;

import com.vbb.bot.basebotmodule.api.methods.interfaces.Method;
import com.vbb.bot.basebotmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.updates.GetWebhookInfo;
import org.telegram.telegrambots.meta.api.objects.WebhookInfo;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetWebhookInfoMethod implements Method<WebhookInfo> {

    private final GetWebhookInfo method;

    public GetWebhookInfoMethod() {
        this(new GetWebhookInfo());
    }

    public GetWebhookInfoMethod(@NotNull GetWebhookInfo method) {
        this.method = method;
    }

    @Override
    public WebhookInfo call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super WebhookInfo> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
