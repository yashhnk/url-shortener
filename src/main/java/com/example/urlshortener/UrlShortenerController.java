package com.example.urlshortener;

import io.micrometer.core.annotation.Counted;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    private HashMap<String, String> map = new HashMap<>();

    @PostMapping("/shorten")
    @Counted("shorten_requests_total")
    public String shorten(@RequestBody String originalUrl) {
        String shortId = UUID.randomUUID().toString().substring(0, 6);
        map.put(shortId, originalUrl);
        return shortId;
    }

    @GetMapping("/retrieve/{shortId}")
    @Counted("retrieve_requests_total")
    public String retrieve(@PathVariable String shortId) {
        return map.getOrDefault(shortId, "URL Not Found");
    }
}
