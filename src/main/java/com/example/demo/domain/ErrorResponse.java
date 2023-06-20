package com.example.demo.domain;


import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ErrorResponse {
    /**
     * {
     * "code" : "400",
     * "message" : "잘못된 요청입니다." ,
     * "validation" :{
     * "title" : "값을 입력해 주세요",
     * "content" : "값을 입력해 주세요"
     * }
     * }
     */
    private final String code;
    private final String message;
    private final Map<String, String> validation;


    @Builder
    public ErrorResponse(String code, String message, Map<String, String> validation) {
        this.code = code;
        this.message = message;
        this.validation = validation != null ? validation : new HashMap<>();
    }

    public void addValidation(String fieldName, String errorMessage) {
        this.validation.put(fieldName, errorMessage);
    }
}
