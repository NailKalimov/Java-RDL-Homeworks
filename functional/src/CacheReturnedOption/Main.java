package CacheReturnedOption;

public class Main {
    public static void main(String[] args) {
        Cache<String, String> cache = new Cache<>(3, 3);
        cache.put("k1", "1");
        cache.put("k2", "2");
        cache.put("k3", "3");
        System.out.println("Initialized cache: " + cache);
        cache.getContent("k1");
        System.out.println("After taking k1: " + cache);
        cache.put("k4", "4");
        System.out.println("After insert k4: " + cache);
        System.out.println("attempt to get a nonexistent object from the cache: " + cache.getContent("k5"));
    }
}
