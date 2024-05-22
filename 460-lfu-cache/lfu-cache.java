
/*
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
*/


public class LFUCache {
    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Node> keyToNode;
    private final Map<Integer, DoublyLinkedList> frequencyToNodes;

    // Node class to store key, value, and frequency
    private static class Node {
        int key, value, frequency;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    // Doubly linked list class to store nodes
    private static class DoublyLinkedList {
        Node head, tail;
        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
        }

        void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToNode = new HashMap<>();
        this.frequencyToNodes = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateNode(node);
            return;
        }
        if (keyToNode.size() >= capacity) {
            DoublyLinkedList minFreqList = frequencyToNodes.get(minFrequency);
            Node toEvict = minFreqList.tail.prev;
            minFreqList.removeNode(toEvict);
            keyToNode.remove(toEvict.key);
            if (minFreqList.isEmpty()) {
                frequencyToNodes.remove(minFrequency);
            }
        }
        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        frequencyToNodes.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
        minFrequency = 1;
    }

    private void updateNode(Node node) {
        int frequency = node.frequency;
        DoublyLinkedList list = frequencyToNodes.get(frequency);
        list.removeNode(node);
        if (list.isEmpty()) {
            frequencyToNodes.remove(frequency);
            if (minFrequency == frequency) {
                minFrequency++;
            }
        }
        node.frequency++;
        frequencyToNodes.computeIfAbsent(node.frequency, k -> new DoublyLinkedList()).addNode(node);
    }
}
