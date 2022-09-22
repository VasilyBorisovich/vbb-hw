package com.vbb.bot.basebotmodule.commands.authority;

import java.util.EnumSet;

public enum For {
    CREATOR,
    ADMIN,
    GROUP_ADMIN,
    USER;

    public static EnumSet<For> all() {
        return EnumSet.allOf(For.class);
    }
}
