package com.gumi.v2.specification;

import com.gumi.v2.ApiKeyIssueCheckRequest;

public class OrSpecification extends CompositeApiKeyIssueCondition {
    private ApiKeyIssueCondition left;
    private ApiKeyIssueCondition right;

    public OrSpecification(ApiKeyIssueCondition left, ApiKeyIssueCondition right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(ApiKeyIssueCheckRequest candidate) {
        return left.isSatisfiedBy(candidate) || right.isSatisfiedBy(candidate);
    }
}
