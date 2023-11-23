package com.gumi.v2.condition;

import com.gumi.v2.ApiKeyIssueCheckRequest;
import com.gumi.v2.specification.CompositeApiKeyIssueCondition;

public class ExistApiKeyCondition extends CompositeApiKeyIssueCondition {
    @Override
    public boolean isSatisfiedBy(ApiKeyIssueCheckRequest request) {
        return request.isApiKeyExist();
    }
}
