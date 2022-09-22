package com.vbb.bot.basebotmodule.commands;

import com.vbb.bot.basebotmodule.commands.authority.For;
import com.vbb.bot.basebotmodule.commands.context.CallbackQueryContext;
import java.util.EnumSet;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class SimpleCallbackQueryCommand implements CallbackQueryCommand {

    private final String command;
    private final Consumer<CallbackQueryContext> contextConsumer;
    private final EnumSet<For> authority;

    public SimpleCallbackQueryCommand(@NotNull String command,
                                      @NotNull Consumer<CallbackQueryContext> contextConsumer) {
        this(command, For.all(), contextConsumer);
    }

    public SimpleCallbackQueryCommand(@NotNull String command,
                                      @NotNull For role,
                                      @NotNull Consumer<CallbackQueryContext> contextConsumer) {
        this(command, EnumSet.of(role), contextConsumer);
    }

    public SimpleCallbackQueryCommand(@NotNull String command,
                                      @NotNull EnumSet<For> authority,
                                      @NotNull Consumer<CallbackQueryContext> contextConsumer) {
        this.command = command;
        this.contextConsumer = contextConsumer;
        this.authority = authority;
    }

    @Override
    public String command() {
        return command;
    }

    @SuppressWarnings("unchecked")
    @Override
    public EnumSet<For> authority() {
        return authority;
    }

    @Override
    public void accept(@NotNull CallbackQueryContext context) {
        contextConsumer.accept(context);
    }
}
