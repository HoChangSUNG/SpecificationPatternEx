package com.specification.v1;

import com.specification.OrderRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AndBlockingCondition extends CompositeBlockingCondition{

    private final BlockingCondition leftCondition;
    private final BlockingCondition rightCondition;

    @Override
    public boolean isSatisfy(OrderRequest orderRequest) {
        return leftCondition.isSatisfy(orderRequest) && rightCondition.isSatisfy(orderRequest);
    }
}
