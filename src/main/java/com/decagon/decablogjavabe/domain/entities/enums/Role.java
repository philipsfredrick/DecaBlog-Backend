package com.decagon.decablogjavabe.domain.entities.enums;

public enum Role {

    ADMIN("Admin"),
    DECADEV("Decadev");

    private String display;

    Role(String display) {
        this.display = display;
    }
}
