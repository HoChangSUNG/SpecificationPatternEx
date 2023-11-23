package com.gumi.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

import static com.gumi.v1.ApiKeyIssueConditions.*;


@Service
@RequiredArgsConstructor
public class ApiKeyIssueRequesterApplication {

 private final Predicate<ApiKeyIssueCheckRequest> condition =  IS_TEST_API_KEY.and(EXIST_API_KEY.negate()).and(EXIST_ACCOUNT)
                .or(IS_PROD_API_KEY.and(EXIST_API_KEY.negate()).and(EXIST_ACCOUNT));








}
