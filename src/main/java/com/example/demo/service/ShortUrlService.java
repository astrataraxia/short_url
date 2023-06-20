package com.example.demo.service;

import com.example.demo.domain.UrlEntry;
import com.example.demo.dto.ShortUrlCreateResponseDto;
import com.example.demo.exception.NotFoundShortUrlException;
import com.example.demo.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final UrlRepository urlRepository;

    public ShortUrlCreateResponseDto saveUrl(String origin) {
        UrlEntry entity = urlRepository.saveUrl(origin);
        return ShortUrlCreateResponseDto.from(entity);
    }

    public String getOriginUrlByShortUrl(String shortUrlKey) {
        UrlEntry urlEntry = urlRepository.findByShortUrl(shortUrlKey)
                .orElseThrow(NotFoundShortUrlException::new);
        urlEntry.countUp();

        urlRepository.update(urlEntry);

        return urlEntry.fullPath(urlEntry);
    }

}
