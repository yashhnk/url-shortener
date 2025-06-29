import org.junit.Test;
import static org.junit.Assert.*;

public class UrlShortenerTest {
    @Test
    public void testShortenAndRetrieve() {
        UrlShortener us = new UrlShortener();
        String shortId = us.shorten("https://example.com");
        assertEquals("https://example.com", us.retrieve(shortId));
    }
}

