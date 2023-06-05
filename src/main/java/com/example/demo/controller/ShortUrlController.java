package com.example.demo.controller;

import com.example.demo.domain.UrlEntry;
import com.example.demo.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @GetMapping("/")
    public String goHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("url", new UrlEntry());
        return "home";
    }

    @PostMapping("/create")
    public String urlMake(String shortUrl, RedirectAttributes redirectAttributes) {
        UrlEntry url = shortUrlService.saveUrl(shortUrl);
        redirectAttributes.addAttribute("origin",url.getOriginUrl());
        redirectAttributes.addAttribute("short",url.getShortUrl());
        return "redirect:/url";
    }

    @GetMapping("/url")
    public String shortUrlPage() {
        return "url";
    }

    @GetMapping("/{shortUrl}")
    public String redirectToOriginUrl(@PathVariable String shortUrl, RedirectAttributes redirectAttributes) {
        UrlEntry urlEntry = shortUrlService.findByShortUrl(shortUrl);
        String originUrl = urlEntry.getOriginUrl();
        redirectAttributes.addAttribute("originUrl",originUrl);
        urlEntry.countUp();
        log.info("count = {}", urlEntry.getRequestCount());
        return "redirect:https://{originUrl}";
    }
}
