package io.humb1t.simpleCacheImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

class Cache<K, V> extends LinkedHashMap<K, V> {
    private int maxSize;

    /**
     * Constructs an empty <tt>Cache</tt> instance with the
     * specified initial capacity and max size
     *
     * @param  initialCapacity the initial capacity
     * @param  maxSize the max size
     * @throws IllegalArgumentException if the initial capacity is negative
     *         or the max size is nonpositive
     */
    public Cache(int initialCapacity, int maxSize) {
        super(initialCapacity, 0.75f, true);
        if(maxSize <= 0)
            throw new IllegalArgumentException("Illegal max size: " + maxSize);
        else
            this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxSize;
    }
//    String getContent(String key){
//        String result;
//        if ((result = cache.get(key)) == null){
//            result = getContentFromURL(key).toString();
//        }
//        put(key, result);
//        return result;
//    }
//
//    Stack<String> getStack(){
//        return stack;
//    }
//
//    void put(String key, String content){
//        if(cache.containsKey(key) | capacity<cache.size()+1){
//            String remove;
//            if(cache.containsKey(key)){
//                remove = key;
//            } else {
//                remove = stack.firstElement();
//            }
//            cache.remove(remove);
//            stack.removeElement(remove);
//        }
//        cache.put(key,content);
//        stack.add(key);
//    }
//
//    private StringBuilder getContentFromURL(String key){
//        StringBuilder result = new StringBuilder();
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(key).openStream()));
//            String str;
//            while ((str = reader.readLine())!=null){
//                result.append(str);
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
}

