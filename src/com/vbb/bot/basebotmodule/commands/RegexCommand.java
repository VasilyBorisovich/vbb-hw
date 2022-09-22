package com.vbb.bot.basebotmodule.commands;

import com.vbb.bot.basebotmodule.commands.context.RegexMessageContext;
import java.util.regex.Pattern;

public interface RegexCommand extends Command<RegexMessageContext> {

    Pattern pattern();
}
