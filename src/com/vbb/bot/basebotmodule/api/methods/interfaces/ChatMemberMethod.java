package com.vbb.bot.basebotmodule.api.methods.interfaces;

import java.io.Serializable;

public interface ChatMemberMethod<M extends Method, T extends Serializable>
        extends ChatMethod<M, T>, UserMethod<M, T> {
}
