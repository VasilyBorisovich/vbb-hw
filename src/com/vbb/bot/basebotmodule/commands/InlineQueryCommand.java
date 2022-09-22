package com.vbb.bot.basebotmodule.commands;

import com.vbb.bot.basebotmodule.commands.context.InlineQueryContext;

public interface InlineQueryCommand extends Command<InlineQueryContext> {

    String command();
}
