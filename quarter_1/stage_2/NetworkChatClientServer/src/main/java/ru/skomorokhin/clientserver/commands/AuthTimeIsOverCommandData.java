package ru.skomorokhin.clientserver.commands;

import java.io.Serializable;

public class AuthTimeIsOverCommandData implements Serializable {

    private final String authTimeIsOverMessage;

    public AuthTimeIsOverCommandData(String authTimeIsOverMessage) {
        this.authTimeIsOverMessage = authTimeIsOverMessage;
    }

    public String getAuthTimeIsOverMessage() {
        return authTimeIsOverMessage;
    }
}
