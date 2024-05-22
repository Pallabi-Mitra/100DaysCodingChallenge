

public class LFUCache {
    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Integer> keyToValue;
    private final Map<Integer, Integer> keyToFrequency;
    private final Map<Integer, LinkedHashSet<Integer>> frequencyToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToValue = new HashMap<>();
        this.keyToFrequency = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        int frequency = keyToFrequency.get(key);
        frequencyToKeys.get(frequency).remove(key);
        if (frequencyToKeys.get(frequency).isEmpty()) {
            frequencyToKeys.remove(frequency);
            if (minFrequency == frequency) {
                minFrequency++;
            }
        }
        frequency++;
        keyToFrequency.put(key, frequency);
        frequencyToKeys.computeIfAbsent(frequency, k -> new LinkedHashSet<>()).add(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            get(key); // Update the frequency of the key
            return;
        }
        if (keyToValue.size() >= capacity) {
            int evictKey = frequencyToKeys.get(minFrequency).iterator().next();
            frequencyToKeys.get(minFrequency).remove(evictKey);
            if (frequencyToKeys.get(minFrequency).isEmpty()) {
                frequencyToKeys.remove(minFrequency);
            }
            keyToValue.remove(evictKey);
            keyToFrequency.remove(evictKey);
        }
        keyToValue.put(key,value);
        keyToFrequency.put(key, 1);
        frequencyToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFrequency = 1; // Reset the minimum frequency to 1
    }
}

