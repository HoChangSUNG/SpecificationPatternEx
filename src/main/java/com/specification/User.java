package com.specification;

import lombok.Builder;
import lombok.Getter;


@Getter
public class User {

    private boolean isBlack;
    private int age;

    @Builder
    public User(boolean isBlack, int age) {
        this.isBlack = isBlack;
        this.age = age;
    }

    public boolean isBlack() {
        return isBlack;
    }

}
