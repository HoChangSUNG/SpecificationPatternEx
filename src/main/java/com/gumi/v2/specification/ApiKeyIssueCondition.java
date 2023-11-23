package com.gumi.v2.specification;

import com.gumi.v2.ApiKeyIssueCheckRequest;

public interface ApiKeyIssueCondition {

    boolean isSatisfiedBy(ApiKeyIssueCheckRequest candidate);
    ApiKeyIssueCondition and(ApiKeyIssueCondition other);
    ApiKeyIssueCondition or(ApiKeyIssueCondition other);
    ApiKeyIssueCondition not();

}
