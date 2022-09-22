package com.vbb.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class IotBotConfig {
    private static final Integer DEFAULT_CREATOR_ID = -1;

    @JsonProperty(required = true)
    private String token;

    @JsonProperty(required = true)
    private String username;

    @NotNull
    @JsonProperty(required = true)
    private Integer creatorId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCreatorId() {
        if (this.creatorId == null) {
            return DEFAULT_CREATOR_ID;
        }
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        if (creatorId == null) {
            this.creatorId = DEFAULT_CREATOR_ID;
        }
        else
            this.creatorId = creatorId;
    }

    @Override
    public String toString() {
        return "BotConfig{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", creatorId=" + creatorId +
                '}';
    }
}
