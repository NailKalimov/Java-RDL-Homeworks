package io.humb1t.simpleCacheImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Cache {
    private Map<String, String> cache;
    private Stack<String> stack;
    private int capacity;

    public Cache(int capacity) {
        cache = new HashMap<>(capacity);
        stack = new Stack<>();
        this.capacity = capacity;
    }

    String getContent(String key){
        String result;
        if ((result = cache.get(key)) == null){
            result = getContentFromURL(key).toString();
        }
        put(key, result);
        return result;
    }

    Stack<String> getStack(){
        return stack;
    }

    void put(String key, String content){
        if(cache.containsKey(key) | capacity<cache.size()+1){
            String remove;
            if(cache.containsKey(key)){
                remove = key;
            } else {
                remove = stack.firstElement();
            }
            cache.remove(remove);
            stack.removeElement(remove);
        }
        cache.put(key,content);
        stack.add(key);
    }

    private StringBuilder getContentFromURL(String key){
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(key).openStream()));
            String str;
            while ((str = reader.readLine())!=null){
                result.append(str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

