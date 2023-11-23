package com.gumi.v1.condition;

import com.gumi.v1.ApiKeyIssueCheckRequest;
import com.gumi.v1.ApiKeyIssueCondition;

public class ContractCompleteCondition implements ApiKeyIssueCondition {
    @Override
    public boolean test(ApiKeyIssueCheckRequest request) {
        return request.isContractCompleteExist();
    }
}