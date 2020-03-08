package io.humb1t.simpleCacheImplementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cache cache = new Cache(3);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter URL: ");
        String url = sc.next();
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        System.out.println(cache.getContent(url));
        endTime = System.currentTimeMillis();
        System.out.println("Load time from Internet: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        System.out.println(cache.getContent(url));
        endTime = System.currentTimeMillis();
        System.out.println("Load time from cache: " + (endTime - startTime) + "ms");
    }
}
