package com.specification;

import com.specification.v1.BlockingCondition;
import com.specification.v1.CompositeBlockingCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.*;

public class BlockingPolicyV1Test {

    @Mock
    private BlockingCondition sut;
    private User.UserBuilder userBuilder = User.builder();
    private OrderRequest.OrderRequestBuilder orderRequestBuilder = OrderRequest.builder();

    @Test
    @DisplayName("정책: 블랙 리스트인 유저는 주문을 실패한다.")
    void test01() {
        OrderRequest orderRequest = orderRequestBuilder
                .user(userBuilder.isBlack(true).build())
                .build();
        sut = createBlackOrderCondition();
        assertThat(sut.isSatisfy(orderRequest)).isTrue();
    }


    @Test
    @DisplayName("정책: 나이가 18세 이하인 유저는 주문을 실패한다.")
    void test02() {
        OrderRequest orderRequest = orderRequestBuilder
                .user(userBuilder.age(18).build())
                .build();
        sut = createAgeCondition(18);
        assertThat(sut.isSatisfy(orderRequest)).isTrue();
    }


    @Test
    @DisplayName("정책: 나이가 18세 이하이거나, 블랙리스트인 유저는 주문을 실패한다.")
    void test03() {
        OrderRequest orderRequest = orderRequestBuilder
                .user(userBuilder.age(18).isBlack(true).build())
                .build();
        sut = createAgeCondition(18).or(createBlackOrderCondition());

        assertThat(sut.isSatisfy(orderRequest)).isTrue();
    }

    private CompositeBlockingCondition createAgeCondition(int age) {
        return new CompositeBlockingCondition() {
            @Override
            public boolean isSatisfy(OrderRequest orderRequest) {
                return orderRequest.getAge() <= age;
            }
        };
    }

    private CompositeBlockingCondition createBlackOrderCondition() {
        return new CompositeBlockingCondition() {
            @Override
            public boolean isSatisfy(OrderRequest orderRequest) {
                return orderRequest.hasBlack();
            }
        };
    }

}
