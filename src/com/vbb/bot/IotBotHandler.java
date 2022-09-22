package com.vbb.bot;

import com.vbb.bot.basebotmodule.BotHandler;
import com.vbb.bot.basebotmodule.api.methods.Methods;
import com.vbb.bot.basebotmodule.api.methods.other.SendChatActionMethod;
import com.vbb.bot.basebotmodule.commands.CommandRegistry;
import com.vbb.bot.basebotmodule.commands.SimpleCommand;
import com.vbb.bot.basebotmodule.commands.authority.For;
import com.vbb.bot.basebotmodule.commands.authority.SimpleAuthority;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class IotBotHandler extends BotHandler {
    private final IotBotConfig botConfig;
    private final CommandRegistry<For> commands;

    public IotBotHandler(IotBotConfig botConfig) {
        this.botConfig = botConfig;
        final var authority = new SimpleAuthority(this, botConfig.getCreatorId());
        commands = new CommandRegistry<>(this, authority);

        commands.register(new SimpleCommand("/action", For.CREATOR, ctx -> {
            if (ctx.argumentsLength() != 1) return;
            ActionType actionType = ActionType.get(ctx.argument(0, "typing"));
            if (actionType == null) return;
            SendChatActionMethod sendChatActionMethod = Methods.sendChatAction(ctx.chatId(), actionType);
            if (sendChatActionMethod == null) return;
            sendChatActionMethod.callAsync(ctx.sender);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SendMessage response = new SendMessage();
            response.setChatId(ctx.chatId());
            response.setText(String.format("Hello from {%d}", ctx.messageId()));
            try {
                execute(response);
            } catch (TelegramApiException e) {
                log.error("execute(response) fail: " + e.getLocalizedMessage());
            }
        }));

        addMethodPreprocessor(SendMessage.class, m -> {
            m.setAllowSendingWithoutReply(true);
            m.disableWebPagePreview();
        });
        addMethodPreprocessor(EditMessageText.class, EditMessageText::disableWebPagePreview);
    }

    @Override
    protected BotApiMethod<?> onUpdate(@NotNull Update update) {
        if (commands.handleUpdate(update)) {
            return null;
        }
        // handle other updates
        return null;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
}
