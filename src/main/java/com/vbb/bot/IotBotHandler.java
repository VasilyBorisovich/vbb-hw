package com.vbb.bot;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.api.methods.Methods;
import com.annimon.tgbotsmodule.api.methods.other.SendChatActionMethod;
import com.annimon.tgbotsmodule.commands.CommandRegistry;
import com.annimon.tgbotsmodule.commands.SimpleCommand;
import com.annimon.tgbotsmodule.commands.authority.For;
import com.annimon.tgbotsmodule.commands.authority.SimpleAuthority;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

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
            Methods.sendMessage(ctx.chatId(), String.format("Hello from {}", ctx.messageId()));
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
