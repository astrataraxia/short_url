package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class UrlEntry {

    private String originUrl;
    private String shortUrl;
    private int requestCount;

    public UrlEntry() {
    }

    private UrlEntry(String originUrl) {
        this.originUrl = saveOrigin(originUrl);
        this.shortUrl = makeShort(originUrl);
        this.requestCount = 0;
    }


    public static UrlEntry of(String originUrl) {
        return new UrlEntry(originUrl);
    }


    public void countUp() {
        requestCount++;
    }

    private String makeShort(String originUrl) {
        //TODO: Base56 인코딩을 적용해봐야된다. (지금은 그냥 무작위로 적용중).. 암호화는 되도 복호화는 안됨.

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortUrlBuilder = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * characters.length());
            shortUrlBuilder.append(characters.charAt(index));
        }
        return shortUrlBuilder.toString();
    }

    private String saveOrigin(String originUrl) {
        if (originUrl.startsWith("https://www.")) {
            originUrl = originUrl.substring(12); // Remove "https://www." (12 characters)
        } else if (originUrl.startsWith("https://")) {
            originUrl = originUrl.substring(8); // Remove "https://" (8 characters)
        }
        return originUrl;
    }

    public String fullPath(UrlEntry urlEntry) {
        if (urlEntry.getOriginUrl().startsWith("http://") || urlEntry.getOriginUrl().startsWith("https://")) {
            return urlEntry.getOriginUrl();
        } else {
            return  "https://" + urlEntry.getOriginUrl();
        }
    }
}

