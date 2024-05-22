class Node { // define the DLL class
    int key;
    int value; // 2 values
    Node prev,next; // reference pointers

    Node(int key,int value)
    {
        this.key=key;
        this.value=value;
    }
}

// Using DLL and HashMap
// HashMap stores : Key, Address of the node
// DLL stores : Key,value
class LRUCache {

// Create two nodes head and tail with key and value =0

Node head = new Node(0,0);
Node tail = new Node(0,0);

// Create a hashmap to store the key and address of the nodes

HashMap<Integer,Node> mpp = new HashMap<>();

int capacity;

    public LRUCache(int capacity) {

        this.capacity=capacity; // initialize the capacity send through constructor
        head.next=tail; // join head and tail
        tail.prev=head;
        
    }
    
    public int get(int key) { // return value of existing node

        if(mpp.containsKey(key)) // need to change this node to MRU, add before head
        {
            Node newNode = mpp.get(key); // get the value which store the node address from map
           // make new node equal to that node address
            remove(newNode); // remove from dLL also from map
            insert(newNode); // place next to head
            return newNode.value;
        }
        else
        return -1;
        
    }
    
    public void put(int key, int value) { // adding new value
// if map already has the same key, we need to update the value again, we remove it from cache,
//also remove it from the DLL
    if(mpp.containsKey(key)) 
    {
             remove(mpp.get(key));  // get the node address
    }
// if map is full, we need to remove the LRU , which will be before tail before inserting new
    if(mpp.size()==capacity) 
    {
        remove(tail.prev);
    }

    insert(new Node(key,value)); // insert the new node in DLL
   
    }

    private void remove(Node node)
    {
        mpp.remove(node.key); // remove the entry from map

// remove the node from the middle, connect the other two nodes together
        node.next.prev=node.prev;
        node.prev.next=node.next;



    }

    private void insert(Node node) // adding after head
    {
            mpp.put(node.key,node); // new entry in the node

            Node headNext= head.next;

            head.next=node;
            node.prev=head;

            headNext.prev=node;
            node.next=headNext;



    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */