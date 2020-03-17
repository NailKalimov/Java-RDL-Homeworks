package io.humb1t.simpleCacheImplementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cache cache = new Cache(3, 3);
        cache.put("k1", "1");
        cache.put("k2", "2");
        cache.put("k3", "3");
        System.out.println(cache);
        cache.get("k1");
        System.out.println(cache);
        cache.put("k4", "4");
        System.out.println(cache);
//        Cache cache = new Cache(3);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter URL: ");
//        String url = sc.next();
//        long startTime;
//        long endTime;
//        startTime = System.currentTimeMillis();
//        System.out.println(cache.getContent(url));
//        endTime = System.currentTimeMillis();
//        System.out.println("Load time from Internet: " + (endTime - startTime) + "ms");
//        startTime = System.currentTimeMillis();
//        System.out.println(cache.getContent(url));
//        endTime = System.currentTimeMillis();
//        System.out.println("Load time from cache: " + (endTime - startTime) + "ms");
    }
}
