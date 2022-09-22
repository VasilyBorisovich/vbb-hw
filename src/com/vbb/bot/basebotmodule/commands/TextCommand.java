package com.vbb.bot.basebotmodule.commands;

import com.vbb.bot.basebotmodule.commands.context.MessageContext;
import java.util.Set;

public interface TextCommand extends Command<MessageContext> {

    String command();

    default Set<String> aliases() {
        return Set.of();
    }
}
