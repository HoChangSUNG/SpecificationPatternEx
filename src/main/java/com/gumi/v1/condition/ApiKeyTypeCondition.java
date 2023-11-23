package com.gumi.v1.condition;

import com.gumi.v1.ApiKeyIssueCheckRequest;
import com.gumi.v1.ApiKeyIssueCondition;
import com.gumi.v1.ApiKeyType;

public class ApiKeyTypeCondition implements ApiKeyIssueCondition{
    private ApiKeyType apiKeyType;

    public ApiKeyTypeCondition(ApiKeyType apiKeyType) {
        this.apiKeyType = apiKeyType;
    }

    @Override
    public boolean test(ApiKeyIssueCheckRequest request) {
        return request.getApiKeyType() == apiKeyType;
    }
}