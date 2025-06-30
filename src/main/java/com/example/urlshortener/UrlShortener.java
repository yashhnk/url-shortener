package com.example.urlshortener;

import java.util.HashMap;
import java.util.UUID;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

public class UrlShortener {
    private HashMap<String, String> map = new HashMap<>();
    private Counter counter;

    public UrlShortener(MeterRegistry registry) {
        this.counter = registry.counter("url.shorten.count");
    }

    public String shorten(String originalUrl) {
        String shortId = UUID.randomUUID().toString().substring(0, 6);
        map.put(shortId, originalUrl);
        counter.increment(); // Track each shortening
        return shortId;
    }

    public String retrieve(String shortId) {
        return map.getOrDefault(shortId, "URL Not Found");
    }
}
