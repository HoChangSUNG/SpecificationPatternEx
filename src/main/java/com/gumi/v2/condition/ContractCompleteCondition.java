package com.gumi.v2.condition;

import com.gumi.v2.ApiKeyIssueCheckRequest;
import com.gumi.v2.specification.ApiKeyIssueCondition;
import com.gumi.v2.specification.CompositeApiKeyIssueCondition;

public class ContractCompleteCondition extends CompositeApiKeyIssueCondition {
    @Override
    public boolean isSatisfiedBy(ApiKeyIssueCheckRequest request) {
        return request.isContractCompleteExist();
    }
}