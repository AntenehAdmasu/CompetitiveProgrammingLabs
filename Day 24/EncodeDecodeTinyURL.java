// Question link : https://leetcode.com/problems/encode-and-decode-tinyurl/

import java.util.HashMap;

public class EncodeDecodeTinyURL {

    HashMap<String, String> urlCodePair = new HashMap<>();

    public static void main(String[] args) {
        String x = "anteneh";
        System.out.println(x.substring(3));
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int prime = 3;
        for(int i = 0; i < longUrl.length(); i++){
            prime += prime + longUrl.charAt(i);
        }
        urlCodePair.put(""+prime,longUrl);
        return "tinyUrl.com/" + prime;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlCodePair.get(shortUrl.substring(12));
    }
}
