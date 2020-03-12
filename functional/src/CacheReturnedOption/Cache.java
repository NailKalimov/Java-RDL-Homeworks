package CacheReturnedOption;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

class Cache<K, V> extends LinkedHashMap<K, V> {
    private int maxSize;

    /**
     * Constructs an empty <tt>APIAndOptionalHomework.Cache</tt> instance with the
     * specified initial capacity and max size
     *
     * @param initialCapacity the initial capacity
     * @param maxSize         the max size
     * @throws IllegalArgumentException if the initial capacity is negative
     *                                  or the max size is nonpositive
     */
    public Cache(int initialCapacity, int maxSize) {
        super(initialCapacity, 0.75f, true);
        if (maxSize <= 0)
            throw new IllegalArgumentException("Illegal max size: " + maxSize);
        else
            this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }

    /**
     * This method return Optional#empty instead of null if element is missing.
     *
     * @param  key
     * @return Optional<V>
     */
    public Optional<V> getContent(K key) {
        return Optional.ofNullable(super.get(key));
    }
}
