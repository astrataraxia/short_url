package com.example.demo.repository;

import com.example.demo.domain.UrlEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShortUrlRepository implements UrlRepository {

    private static final Map<String, UrlEntry> urls = new HashMap<>();

    @Override
    public UrlEntry saveUrl(String origin) {
        UrlEntry shortUrl = UrlEntry.of(origin);
        urls.put(shortUrl.getShortUrl(), shortUrl);
        return shortUrl;
    }

    @Override
    public UrlEntry findByShortUrl(String shortUrl) {
        return urls.get(shortUrl);
    }

    @Override
    public List<UrlEntry> findAll() {
        return new ArrayList<>(urls.values());
    }
}
