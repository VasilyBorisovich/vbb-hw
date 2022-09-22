package com.vbb.bot.basebotmodule.api.methods.interfaces;

import java.io.Serializable;

public interface MediaMessageMethod<M extends Method, T extends Serializable>
        extends ReplyMarkupSupportedMessageMethod<M, T>, InputFileMethod<M, T>, ProtectedContentMethod<M, T> {

}