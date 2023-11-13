package com.specification;

import com.specification.v2.BlockingCondition2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import static org.assertj.core.api.Assertions.assertThat;

public class BlockingPolicyV2Test {


    @Mock
    private BlockingCondition2 sut;
    private final User.UserBuilder userBuilder = User.builder();
    private final OrderRequest.OrderRequestBuilder orderRequestBuilder = OrderRequest.builder();

    @Test
    @DisplayName("조건: 블랙 리스트인 유저는 조건에 만족한다.")
    void test01() {
        OrderRequest orderRequest = orderRequestBuilder
                .user(userBuilder.isBlack(true).build())
                .build();
        sut = createBlackOrderCondition();

        Assertions.assertThat(sut.isSatisfy(orderRequest)).isTrue();
    }


    @Test
    @DisplayName("조건: 나이가 18세 이하인 유저는 조건에 만족한다.")
    void test02() {
        OrderRequest orderRequest = orderRequestBuilder
                .user(userBuilder.age(18).build())
                .build();
        sut = createAgeCondition(18);
        assertThat(sut.isSatisfy(orderRequest)).isTrue();
    }


    @Test
    @DisplayName("조건: 나이가 18세 이하이거나, 블랙리스트라면 조건에 만족한.")
    void test03() {
        OrderRequest orderRequest = orderRequestBuilder
                .user(userBuilder.age(18).isBlack(true).build())
                .build();
        sut = createAgeCondition(18).or(createBlackOrderCondition());

        assertThat(sut.isSatisfy(orderRequest)).isTrue();
    }

    private BlockingCondition2 createAgeCondition(int age) {
        return request -> request.getAge()<=age;
    }

    private BlockingCondition2 createBlackOrderCondition() {
        return request -> request.hasBlack();
    }
}
