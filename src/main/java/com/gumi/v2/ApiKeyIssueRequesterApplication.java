package com.gumi.v2;

import com.gumi.v2.specification.ApiKeyIssueCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import static com.gumi.v2.ApiKeyIssueConditions.*;
import static com.gumi.v2.specification.CompositeApiKeyIssueCondition.not;
import static com.gumi.v2.specification.CompositeApiKeyIssueCondition.or;
import static com.gumi.v2.specification.CompositeApiKeyIssueCondition.and;


@Service
@RequiredArgsConstructor
public class ApiKeyIssueRequesterApplication {

    private final ApiKeyIssueCondition condition = IS_TEST_API_KEY
            .and(EXIST_API_KEY.not())
            .and(EXIST_ACCOUNT)
            .or(IS_PROD_API_KEY.and(EXIST_API_KEY.not()).and(EXIST_ACCOUNT));


    private final ApiKeyIssueCondition condition2 =
            or(
                    and(IS_TEST_API_KEY, EXIST_ACCOUNT, not(EXIST_API_KEY)),
                    and(IS_PROD_API_KEY, EXIST_ACCOUNT, IS_CONTRACT_COMPLETE, not(EXIST_API_KEY))
            );
}
