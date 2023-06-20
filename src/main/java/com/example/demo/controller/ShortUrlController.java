package com.example.demo.controller;

import com.example.demo.dto.OriginUrlDto;
import com.example.demo.dto.ShortUrlCreateResponseDto;
import com.example.demo.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URISyntaxException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping("/create")
    public ResponseEntity<ShortUrlCreateResponseDto> createShortUrl(@RequestBody OriginUrlDto origin) {
        return ResponseEntity.ok().body(shortUrlService.saveUrl(origin.getOriginUrl()));
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirectToOriginUrl(@PathVariable String shortUrl) throws URISyntaxException {
        String url = shortUrlService.getOriginUrlByShortUrl(shortUrl);
        return new RedirectView(url);
    }
}
