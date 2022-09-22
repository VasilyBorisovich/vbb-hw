package com.vbb.bot.basebotmodule.api.methods.interfaces;

import java.io.Serializable;

public interface UserMethod<M extends Method, T extends Serializable> extends Method<T> {

    Long getUserId();

    M setUserId(Long userId);
}