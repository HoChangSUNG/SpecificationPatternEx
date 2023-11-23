package com.gumi.v1;

import java.util.function.Predicate;

public interface ApiKeyIssueCondition extends Predicate<ApiKeyIssueCheckRequest> {

    @Override
    boolean test(ApiKeyIssueCheckRequest apiKeyIssueCheckRequest);

}
