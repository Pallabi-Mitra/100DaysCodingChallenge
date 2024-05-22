

public class LFUCache {
    private final int capacity; // Maximum capacity of the cache
    private int minFrequency; // Minimum frequency of any key in the cache
    private final Map<Integer, Integer> keyToValue; // Maps keys to their values
    private final Map<Integer, Integer> keyToFrequency; // Maps keys to their frequencies
    private final Map<Integer, LinkedHashSet<Integer>> frequencyToKeys; // Maps frequencies to sets of keys with that frequency

    // Constructor to initialize the LFUCache with given capacity
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToValue = new HashMap<>();
        this.keyToFrequency = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
    }

    // Method to get the value of a key
    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1; // Return -1 if key is not present in the cache
        }
        // Get the current frequency of the key
        int frequency = keyToFrequency.get(key);
        // Remove the key from the current frequency's set
        frequencyToKeys.get(frequency).remove(key);
        // If the current frequency's set is empty, remove the frequency from the map
        if (frequencyToKeys.get(frequency).isEmpty()) {
            frequencyToKeys.remove(frequency);
            // If the minimum frequency was the current frequency, increment minFrequency
            if (minFrequency == frequency) {
                minFrequency++;
            }
        }
        // Increment the frequency of the key
        frequency++;
        // Update the key's frequency in keyToFrequency map
        keyToFrequency.put(key, frequency);
        // Add the key to the new frequency's set
        frequencyToKeys.computeIfAbsent(frequency, k -> new LinkedHashSet<>()).add(key);
        // Return the value of the key
        return keyToValue.get(key);
    }

    // Method to put a key-value pair in the cache
    public void put(int key, int value) {
        if (capacity <= 0) {
            return; // If capacity is zero or less, do nothing
        }
        if (keyToValue.containsKey(key)) {
            // If key is already present, update its value
            keyToValue.put(key, value);
            get(key); // Update the frequency of the key
            return;
        }
        // If the cache is full, evict the least frequently used key
        if (keyToValue.size() >= capacity) {
            // Get the least frequently used key from the set of keys with minFrequency
            int evictKey = frequencyToKeys.get(minFrequency).iterator().next();
            // Remove the evicted key from all maps
            frequencyToKeys.get(minFrequency).remove(evictKey);
            if (frequencyToKeys.get(minFrequency).isEmpty()) {
                frequencyToKeys.remove(minFrequency);
            }
            keyToValue.remove(evictKey);
            keyToFrequency.remove(evictKey);
        }
        // Add the new key-value pair to the cache
        keyToValue.put(key, value);
        keyToFrequency.put(key, 1);
        // Add the new key to the frequencyToKeys map with frequency 1
        frequencyToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        // Reset the minFrequency to 1 since we just added a new key with frequency 1
        minFrequency = 1;
    }
}
