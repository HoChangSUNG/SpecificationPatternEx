package com.gumi.v2.condition;

import com.gumi.v2.ApiKeyIssueCheckRequest;
import com.gumi.v2.specification.CompositeApiKeyIssueCondition;

public class ExistAccountCondition extends CompositeApiKeyIssueCondition {
    @Override
    public boolean isSatisfiedBy(ApiKeyIssueCheckRequest request) {
        return request.isAccountExist();
    }
}
