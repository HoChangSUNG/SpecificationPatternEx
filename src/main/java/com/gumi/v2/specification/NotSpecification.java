package com.gumi.v2.specification;

import com.gumi.v2.ApiKeyIssueCheckRequest;

public class NotSpecification extends CompositeApiKeyIssueCondition {

    private ApiKeyIssueCondition other;

    public NotSpecification(ApiKeyIssueCondition other) {
        this.other = other;
    }

    @Override
    public boolean isSatisfiedBy(ApiKeyIssueCheckRequest candidate) {
        return !other.isSatisfiedBy(candidate);
    }

}
