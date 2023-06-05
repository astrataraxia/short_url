package com.example.demo.repository;

import com.example.demo.domain.UrlEntry;

import java.util.List;

public interface UrlRepository {

    UrlEntry saveUrl(String origin);
    UrlEntry findByShortUrl(String shortUrl);

    List<UrlEntry> findAll();

}
