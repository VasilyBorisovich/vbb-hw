package com.vbb.bot.basebotmodule.api.methods.interfaces;

import java.io.Serializable;

public interface TextMethod<M extends Method, T extends Serializable> extends Method<T> {

    String getText();

    M setText(String text);
}