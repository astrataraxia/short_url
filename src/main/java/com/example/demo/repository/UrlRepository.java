package com.example.demo.repository;

import com.example.demo.domain.UrlEntry;

import java.util.List;
import java.util.Optional;

public interface UrlRepository {

    UrlEntry saveUrl(String origin);
    Optional<UrlEntry> findByShortUrl(String shortUrl);

    void update(UrlEntry urlEntry);
}
