package com.example.demo.dto;

import com.example.demo.domain.UrlEntry;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ShortUrlCreateResponseDto {


    private String originUrl;
    private String shortUrlKey;

    public ShortUrlCreateResponseDto(String originUrl, String shortUrlKey) {
        this.originUrl = originUrl;
        this.shortUrlKey = shortUrlKey;
    }

    public static ShortUrlCreateResponseDto from(UrlEntry entity) {
        return new ShortUrlCreateResponseDto(entity.getOriginUrl(), entity.getShortUrl());
    }
}
