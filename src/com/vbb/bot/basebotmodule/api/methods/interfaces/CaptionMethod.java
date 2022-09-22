package com.vbb.bot.basebotmodule.api.methods.interfaces;

import java.io.Serializable;

public interface CaptionMethod<M extends Method, T extends Serializable> extends Method<T> {

    String getCaption();

    M setCaption(String text);
}