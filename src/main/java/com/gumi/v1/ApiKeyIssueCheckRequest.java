package com.gumi.v1;

import flab.gumipayments.domain.apikey.ApiKeyType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiKeyIssueCheckRequest {
    private ApiKeyType apiKeyType;
    private boolean accountExist;
    private boolean apiKeyExist;
    private boolean contractCompleteExist;
}
