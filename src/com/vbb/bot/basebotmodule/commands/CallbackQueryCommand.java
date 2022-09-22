package com.vbb.bot.basebotmodule.commands;

import com.vbb.bot.basebotmodule.commands.context.CallbackQueryContext;

public interface CallbackQueryCommand extends Command<CallbackQueryContext> {

    String command();
}
