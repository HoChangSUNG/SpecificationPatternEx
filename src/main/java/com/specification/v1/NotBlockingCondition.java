package com.specification.v1;

import com.specification.OrderRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotBlockingCondition extends CompositeBlockingCondition {

    private final BlockingCondition blockingCondition;

    @Override
    public boolean isSatisfy(OrderRequest orderRequest) {
        return !blockingCondition.isSatisfy(orderRequest);
    }
}
