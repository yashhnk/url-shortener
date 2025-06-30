package com.example.urlshortener;

import org.junit.Test;
import static org.junit.Assert.*;

public class UrlShortenerControllerTest {

    @Test
    public void testShortenAndRetrieve() {
        UrlShortenerController controller = new UrlShortenerController();
        String shortId = controller.shorten("https://www.google.com");
        String retrieved = controller.retrieve(shortId);
        assertEquals("https://www.google.com", retrieved);
    }
}
