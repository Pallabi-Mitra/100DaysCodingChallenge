
/* Using 3 Maps, 1 Set :
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

// Using 2 DLL, 2 HashMaps

// LFUCache class definition
public class LFUCache {
    private final int capacity; // Maximum capacity of the cache
    private int minFrequency; // Minimum frequency of any key in the cache
    private final Map<Integer, Node> keyToNode; // Maps keys to Node objects
    private final Map<Integer, DoublyLinkedList> frequencyToNodes; // Maps frequencies to DoublyLinkedList of nodes

    // Node class to store key, value, and frequency
    private static class Node {
        int key, value, frequency; // Node attributes
        Node prev, next; // Pointers for doubly-linked list
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1; // Initial frequency is 1
        }
    }

    // Doubly linked list class to store nodes
    private static class DoublyLinkedList {
        Node head, tail; // Dummy head and tail nodes for easy list operations
        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        // Method to add a node to the front (right after the head)
        void addNode(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
        }

        // Method to remove a node from the list
        void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        // Method to check if the list is empty
        boolean isEmpty() {
            return head.next == tail;
        }
    }

    // Constructor to initialize the LFUCache with given capacity
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToNode = new HashMap<>();
        this.frequencyToNodes = new HashMap<>();
    }

    // Method to get the value of a key
    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1; // Return -1 if key is not present in the cache
        }
        Node node = keyToNode.get(key); // Retrieve the node
        updateNode(node); // Update the node's frequency
        return node.value; // Return the value
    }

    // Method to put a key-value pair in the cache
    public void put(int key, int value) {
        if (capacity <= 0) {
            return; // If capacity is zero or less, do nothing
        }
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value; // Update the value of the key
            updateNode(node); // Update the node's frequency
            return;
        }
        if (keyToNode.size() >= capacity) {
            // If the cache is full, evict the least frequently used key
            DoublyLinkedList minFreqList = frequencyToNodes.get(minFrequency);
            Node toEvict = minFreqList.tail.prev; // Get the last node in the list
            minFreqList.removeNode(toEvict); // Remove the node from the list
            keyToNode.remove(toEvict.key); // Remove the node from the keyToNode map
            if (minFreqList.isEmpty()) {
                frequencyToNodes.remove(minFrequency); // Remove the list if empty
            }
        }
        // Add the new key-value pair to the cache
        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode); // Add to keyToNode map
        frequencyToNodes.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode); // Add to frequency list with frequency 1
        minFrequency = 1; // Reset the minimum frequency to 1 since we just added a new key with frequency 1
    }

    // Method to update the frequency of a node
    private void updateNode(Node node) {
        int frequency = node.frequency; // Get current frequency
        DoublyLinkedList list = frequencyToNodes.get(frequency); // Get the list of nodes with this frequency
        list.removeNode(node); // Remove the node from the list
        if (list.isEmpty()) {
            frequencyToNodes.remove(frequency); // Remove the list if empty
            if (minFrequency == frequency) {
                minFrequency++; // Increment minFrequency if it was the current frequency
            }
        }
        node.frequency++; // Increment the node's frequency
        frequencyToNodes.computeIfAbsent(node.frequency, k -> new DoublyLinkedList()).addNode(node); // Add the node to the new frequency list
    }
}
