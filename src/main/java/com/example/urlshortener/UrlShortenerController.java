package com.example.urlshortener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class UrlShortenerController {

    private HashMap<String, String> map = new HashMap<>();

    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestParam("url") String originalUrl) {
        String shortId = UUID.randomUUID().toString().substring(0, 6);
        map.put(shortId, originalUrl);
        return ResponseEntity.ok(shortId);
    }

    @GetMapping("/{shortId}")
    public void redirect(@PathVariable String shortId, HttpServletResponse response) throws IOException {
        String originalUrl = map.get(shortId);
        if (originalUrl != null) {
            response.sendRedirect(originalUrl);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
