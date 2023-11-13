package com.specification.v2;

import com.specification.OrderRequest;

@FunctionalInterface
public interface BlockingCondition2 {
    boolean isSatisfy(OrderRequest orderRequest);

    default BlockingCondition2 and(BlockingCondition2 other) {
        return (orderRequest -> this.isSatisfy(orderRequest) && other.isSatisfy(orderRequest));
    }

    default BlockingCondition2 or(BlockingCondition2 other) {
        return (orderRequest -> this.isSatisfy(orderRequest) || other.isSatisfy(orderRequest));
    }

    default BlockingCondition2 not() {
        return (orderRequest -> !this.isSatisfy(orderRequest));
    }
}
