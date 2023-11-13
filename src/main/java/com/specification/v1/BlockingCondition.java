package com.specification.v1;

import com.specification.OrderRequest;

public interface BlockingCondition {

    boolean isSatisfy(OrderRequest orderRequest);
    BlockingCondition and(BlockingCondition other);
    BlockingCondition or(BlockingCondition other);
    BlockingCondition not();

}
