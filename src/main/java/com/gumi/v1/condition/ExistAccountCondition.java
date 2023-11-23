package com.gumi.v1.condition;

import com.gumi.v1.ApiKeyIssueCheckRequest;
import com.gumi.v1.ApiKeyIssueCondition;

public class ExistAccountCondition implements ApiKeyIssueCondition {
    @Override
    public boolean test(ApiKeyIssueCheckRequest request) {
        return request.isAccountExist();
    }
}
