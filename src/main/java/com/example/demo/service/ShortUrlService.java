package com.example.demo.service;

import com.example.demo.domain.UrlEntry;
import com.example.demo.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final UrlRepository urlRepository;

    public UrlEntry saveUrl(String origin) {
        return urlRepository.saveUrl(origin);
    }

    public UrlEntry findByShortUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }


    public List<UrlEntry> findAll() {
        return urlRepository.findAll();
    }
}
