package com.gumi.v2;

public enum ApiKeyType {
    TEST("테스트"),
    PRODUCTION("실서비스");

    private final String message;

    ApiKeyType(String message) {
        this.message = message;
    }
}
