package com.gumi.v2.condition;

import com.gumi.v2.ApiKeyIssueCheckRequest;
import com.gumi.v2.ApiKeyType;
import com.gumi.v2.specification.ApiKeyIssueCondition;
import com.gumi.v2.specification.CompositeApiKeyIssueCondition;

public class ApiKeyTypeCondition extends CompositeApiKeyIssueCondition {
    private ApiKeyType apiKeyType;

    public ApiKeyTypeCondition(ApiKeyType apiKeyType) {
        this.apiKeyType = apiKeyType;
    }

    @Override
    public boolean isSatisfiedBy(ApiKeyIssueCheckRequest request) {
        return request.getApiKeyType() == apiKeyType;
    }

}