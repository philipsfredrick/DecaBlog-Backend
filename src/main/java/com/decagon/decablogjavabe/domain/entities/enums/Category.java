package com.decagon.decablogjavabe.domain.entities.enums;

import lombok.Getter;

@Getter
public enum Category {
    PYTHON(1),
    NODEJS(2),
    JAVA(3),
    REACT(4),
    ANDROID(5),
    ANGULAR(6),
    PHP_LARAVEL(7),
    MYSQL(8);

    private final long id;

    Category(long id) {
        this.id = id;
    }

    public static Category getCategory(long id) {
        for (Category category : Category.values()) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
