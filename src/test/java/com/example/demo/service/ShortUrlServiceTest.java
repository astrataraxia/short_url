package com.example.demo.service;

import com.example.demo.dto.ShortUrlCreateResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ShortUrlServiceTest {

    @Autowired
    ShortUrlService shortUrlService;

    @Test
    @DisplayName("Original URL을 저장하면 Dto로 반환해준다.")
    void saveTest() {
        String go = "www.google.com";
        ShortUrlCreateResponseDto responseDto = shortUrlService.saveUrl(go);
        assertThat(responseDto.getOriginUrl()).isEqualTo("google.com");
    }
}
