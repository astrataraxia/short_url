package com.example.demo.repository;

import com.example.demo.domain.UrlEntry;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ShortUrlRepository implements UrlRepository {

    private static final Map<String, UrlEntry> urls = new ConcurrentHashMap<>();

    @Override
    public UrlEntry saveUrl(String origin) {
        UrlEntry shortUrl = UrlEntry.of(origin);
        urls.put(shortUrl.getShortUrl(), shortUrl);
        return shortUrl;
    }

    @Override
    public Optional<UrlEntry> findByShortUrl(String shortUrl) {
        return Optional.ofNullable(urls.get(shortUrl));
    }

    @Override
    public void update(UrlEntry urlEntry) {
        urls.put(urlEntry.getShortUrl(), urlEntry);
    }
}
