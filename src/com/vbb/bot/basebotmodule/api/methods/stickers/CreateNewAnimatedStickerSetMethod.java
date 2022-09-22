package com.vbb.bot.basebotmodule.api.methods.stickers;

import com.vbb.bot.basebotmodule.api.methods.interfaces.InputFileMethod;
import com.vbb.bot.basebotmodule.api.methods.interfaces.UserMethod;
import com.vbb.bot.basebotmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CreateNewAnimatedStickerSetMethod implements
        UserMethod<CreateNewAnimatedStickerSetMethod, Boolean>,
        InputFileMethod<CreateNewAnimatedStickerSetMethod, Boolean> {

    private final CreateNewStickerSet method;

    public CreateNewAnimatedStickerSetMethod() {
        this(new CreateNewStickerSet());
    }

    public CreateNewAnimatedStickerSetMethod(@NotNull CreateNewStickerSet method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public CreateNewAnimatedStickerSetMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getTgsSticker();
    }

    @Override
    public CreateNewAnimatedStickerSetMethod setFile(@NotNull InputFile file) {
        method.setTgsSticker(file);
        return this;
    }

    public String getName() {
        return method.getName();
    }

    public CreateNewAnimatedStickerSetMethod setName(@NotNull String name) {
        method.setName(name);
        return this;
    }

    public String getTitle() {
        return method.getTitle();
    }

    public CreateNewAnimatedStickerSetMethod setTitle(@NotNull String title) {
        method.setTitle(title);
        return this;
    }

    public String getEmojis() {
        return method.getEmojis();
    }

    public CreateNewAnimatedStickerSetMethod setEmojis(@NotNull String emojis) {
        method.setEmojis(emojis);
        return this;
    }

    public Boolean getContainsMasks() {
        return method.getContainsMasks();
    }

    public CreateNewAnimatedStickerSetMethod setContainsMasks(Boolean containsMasks) {
        method.setContainsMasks(containsMasks);
        return this;
    }

    public MaskPosition getMaskPosition() {
        return method.getMaskPosition();
    }

    public CreateNewAnimatedStickerSetMethod setMaskPosition(MaskPosition maskPosition) {
        method.setMaskPosition(maskPosition);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Boolean> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer);
    }
}
