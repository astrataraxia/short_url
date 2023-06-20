package com.example.demo.domain;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UrlEntryTest {

    @Test
    @DisplayName("주소가 들어왔을시, www, https:// , https://www. 이 잘 제거되어 들어오나")
    void originUrlTest() {
        String naver = "www.naver.com";
        String httna = "https://naver.com";
        String httwwna = "https://www.naver.com";

        String originUrl = "naver.com";

        UrlEntry naverUrl= UrlEntry.of(naver);
        UrlEntry https= UrlEntry.of(httna);
        UrlEntry httpswww= UrlEntry.of(httwwna);

        assertThat(naverUrl.getOriginUrl()).isEqualTo(originUrl);
        assertThat(https.getOriginUrl()).isEqualTo(originUrl);
        assertThat(httpswww.getOriginUrl()).isEqualTo(originUrl);
    }

    @Test
    @DisplayName("fullPath가 제대로 만들어 지나 테스트")
    void fullPathTest() {
        String naver = "www.naver.com";
        String httna = "https://naver.com";
        String httwwna = "https://www.naver.com";

        String fullPath = "https://naver.com";

        UrlEntry naverUrl= UrlEntry.of(naver);
        UrlEntry https= UrlEntry.of(httna);
        UrlEntry httpswww= UrlEntry.of(httwwna);

        String na = naverUrl.fullPath(naverUrl);
        String htt = https.fullPath(https);
        String ww = httpswww.fullPath(httpswww);


        assertThat(na).isEqualTo(fullPath);
        assertThat(htt).isEqualTo(fullPath);
        assertThat(ww).isEqualTo(fullPath);
    }

    @Test
    @DisplayName("shortUrl의 길이가 8인가?")
    void shortUrlTest() {
        String naver = "www.naver.com";
        UrlEntry naverUrl= UrlEntry.of(naver);
        assertThat(naverUrl.getShortUrl().length()).isEqualTo(8);
    }

}