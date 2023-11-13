package com.specification;

import com.specification.v1.BlockingCondition;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final BlockingCondition blockingPolicy;

    public void order(OrderRequest orderRequest) {
        if(blockingPolicy.isSatisfy(orderRequest)){
            return;
        }
        orderRepository.save(new Order());
    }
}
