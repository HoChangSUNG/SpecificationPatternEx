package com.gumi.v2;

import com.gumi.v2.condition.ApiKeyTypeCondition;
import com.gumi.v2.condition.ContractCompleteCondition;
import com.gumi.v2.condition.ExistAccountCondition;
import com.gumi.v2.condition.ExistApiKeyCondition;
import com.gumi.v2.specification.ApiKeyIssueCondition;
import org.springframework.stereotype.Component;

import static com.gumi.v2.ApiKeyType.PRODUCTION;
import static com.gumi.v2.ApiKeyType.TEST;


@Component
public class ApiKeyIssueConditions {
    public static final ApiKeyIssueCondition IS_PROD_API_KEY = new ApiKeyTypeCondition(PRODUCTION);
    public static final ApiKeyIssueCondition IS_TEST_API_KEY = new ApiKeyTypeCondition(TEST);
    public static final ApiKeyIssueCondition EXIST_ACCOUNT = new ExistAccountCondition();
    public static final ApiKeyIssueCondition EXIST_API_KEY = new ExistApiKeyCondition();
    public static final ApiKeyIssueCondition IS_CONTRACT_COMPLETE = new ContractCompleteCondition();
}
