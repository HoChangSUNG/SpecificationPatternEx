package com.gumi.v2.specification;

import com.gumi.v2.ApiKeyIssueCheckRequest;

public abstract class CompositeApiKeyIssueCondition implements ApiKeyIssueCondition {

    private static final ApiKeyIssueCondition DUMMY_CONDITION = new CompositeApiKeyIssueCondition() {
        @Override
        public boolean isSatisfiedBy(ApiKeyIssueCheckRequest candidate) {
            return true;
        }
    };

    @Override
    public ApiKeyIssueCondition and(ApiKeyIssueCondition other) {
        return new AndSpecification(this, other);
    }

    @Override
    public ApiKeyIssueCondition or(ApiKeyIssueCondition other) {
        return new OrSpecification(this, other);
    }

    @Override
    public ApiKeyIssueCondition not() {
        return new NotSpecification(this);
    }

    public static ApiKeyIssueCondition and(ApiKeyIssueCondition... condition) {
        ApiKeyIssueCondition curCondition = DUMMY_CONDITION;
        for (ApiKeyIssueCondition apiKeyIssueCondition : condition) {
            curCondition = curCondition.and(apiKeyIssueCondition);
        }
        return curCondition;
    }

    public static ApiKeyIssueCondition or(ApiKeyIssueCondition... condition) {
        ApiKeyIssueCondition curCondition = DUMMY_CONDITION;
        for (ApiKeyIssueCondition apiKeyIssueCondition : condition) {
            curCondition = curCondition.or(apiKeyIssueCondition);
        }
        return curCondition;
    }

    public static ApiKeyIssueCondition not(ApiKeyIssueCondition condition) {
        return condition.not();
    }
}
