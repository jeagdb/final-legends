package com.mti.view.dto.player;

public class PutPlayerDtoRequest {
    public final String name;
    public final String vocation;

    public PutPlayerDtoRequest(String name, String vocation) {
        this.name = name;
        this.vocation = vocation;
    }
}
