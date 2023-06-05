package com.example.demo.repository;

import com.example.demo.domain.UrlEntry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
class ShortUrlRepositoryTest {

    @Autowired
    UrlRepository urlRepository;


    @Test
    @DisplayName("단축 URL을 만들고 세이브 시키기.")
    void saveShortUrlTest() {

        String google = "www.google.com";

        UrlEntry entry = urlRepository.saveUrl(google);

        log.info("shortUrl = {}", entry.getShortUrl());
        log.info("originUrl = {}", entry.getOriginUrl());
        log.info("count = {}", entry.getRequestCount());

        assertThat(entry.getOriginUrl()).isEqualTo(google);
        assertThat(entry.getShortUrl()).isNotNull();
    }

    @Test
    @DisplayName("URL 개별 찾기")
    void findByShortUrlTest() {

        String google = "www.google.com";
        String naver= "www.naver.com";
        String inflearn= "www.inflearn.com";

        UrlEntry go = urlRepository.saveUrl(google);
        UrlEntry na = urlRepository.saveUrl(naver);
        UrlEntry in = urlRepository.saveUrl(inflearn);

        assertThat(urlRepository.findByShortUrl(go.getShortUrl())).isSameAs(go);
        assertThat(urlRepository.findByShortUrl(na.getShortUrl())).isSameAs(na);
        assertThat(urlRepository.findByShortUrl(in.getShortUrl())).isSameAs(in);
    }

    @Test
    @DisplayName("전체 조회")
    void findAllTest() {

        String google = "www.google.com";
        String naver= "www.naver.com";
        String inflearn= "www.inflearn.com";

        UrlEntry go = urlRepository.saveUrl(google);
        UrlEntry na = urlRepository.saveUrl(naver);
        UrlEntry in = urlRepository.saveUrl(inflearn);

        assertThat(urlRepository.findAll().size()).isEqualTo(3);
        assertThat(urlRepository.findAll().contains(go)).isTrue();
        assertThat(urlRepository.findAll().contains(na)).isTrue();
        assertThat(urlRepository.findAll().contains(in)).isTrue();
    }
}