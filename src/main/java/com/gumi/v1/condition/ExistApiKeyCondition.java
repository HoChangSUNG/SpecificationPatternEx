package com.gumi.v1.condition;

import com.gumi.v1.ApiKeyIssueCheckRequest;
import com.gumi.v1.ApiKeyIssueCondition;

public class ExistApiKeyCondition implements ApiKeyIssueCondition {
    @Override
    public boolean test(ApiKeyIssueCheckRequest request) {
        return request.isApiKeyExist();
    }
}
