package com.specification;

import lombok.Builder;

public class OrderRequest {
    private User user;

    @Builder
    public OrderRequest(User user) {
        this.user = user;
    }

    public boolean hasBlack() {
        return user.isBlack();
    }

    public int getAge(){
        return user.getAge();
    }
}
