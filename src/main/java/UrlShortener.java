import java.util.HashMap;
import java.util.UUID;

public class UrlShortener {
    private HashMap<String, String> map = new HashMap<>();

    public String shorten(String originalUrl) {
        String shortId = UUID.randomUUID().toString().substring(0, 6);
        map.put(shortId, originalUrl);
        return shortId;
    }

    public String retrieve(String shortId) {
        return map.getOrDefault(shortId, "URL Not Found");
    }

    public static void main(String[] args) {
        UrlShortener us = new UrlShortener();
        String shortId = us.shorten("https://example.com");
        System.out.println("Shortened: " + shortId);
        System.out.println("Original: " + us.retrieve(shortId));
    }
}
