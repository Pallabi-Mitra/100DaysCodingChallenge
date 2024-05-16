/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

insertCopyNodeInBetween(head);
connectRandomPointers(head);
return getCopyList(head);


        }

    

// insert nodes in between
public void insertCopyNodeInBetween(Node head)
{
        
        Node temp = head;

        while(temp!=null)
        {

           Node copyNode = new Node(temp.val); // cretaing the new node with just temp value
           // insert new node in between 2 nodes
           copyNode.next = temp.next; // linking it with the temp
           temp.next=copyNode; // linking it with the next node of temp
           temp = temp.next.next; // to jump the copy node

        }
}

// connect random pointers

public void connectRandomPointers(Node head)
{
       Node temp = head;
    while(temp!=null)
    {

      Node copyNode = temp.next;
        if(temp.random!=null) // if there is a random pointer of temp
        copyNode.random=temp.random.next; // make the copy node random point to the copy node only, so it will go via the temmp node....the node
        else copyNode.random = null; 
        // if no random it points to null like the temp random points
        temp=temp.next.next; // again temp skips two nodes

    }
}

public Node getCopyList(Node head)
{
        // connecting the next pointer

    Node dummyNode = new Node(-1);
    Node res = dummyNode;
    Node temp=head;
    while(temp!=null)
    {
        res.next=temp.next;//
        temp.next=temp.next.next;//point to the actual next node
        res=res.next;
        temp=temp.next;
    }

return dummyNode.next;
    }


  }
        // Hashing :

        
/*
        HashMap<Node,Node> mpp = new HashMap<>();

        Node temp = head;

        while(temp!=null)
        {
            Node newNode = new Node(temp.val);
            mpp.put(temp,newNode);
            temp=temp.next;
        }

        Node t=head;

        while(t!=null)
        {
            Node copyNode = mpp.get(t);

           // copyNode.next=temp.next;
           // copyNode.random = temp.random;

            copyNode.next=(t.next!=null)?mpp.get(t.next):null;
            copyNode.next=(t.random!=null)?mpp.get(t.random):null;
            t=t.next;


        }

        return mpp.get(head);

        
    }
}

*/
/*
    HashMap<Node,Node> hashMap=new HashMap<>();
    Node temp = head;
//first iteration for inserting deep nodes of every node in the hashmap.
    while(temp != null) {
        Node newNode = new Node(temp.val);
        hashMap.put(temp,newNode);
        temp = temp.next;
    }
    Node t = head;
//second iteration for linking next and random pointer as given question.
    while(t != null) {
        Node node = hashMap.get(t);
        node.next = (t.next != null) ? hashMap.get(t.next):null;
        node.random = (t.random != null) ? hashMap.get(t.random):null;
        t = t.next;
    }
    return hashMap.get(head); // the copy of the head node is returned, which is the new 
    //head of LL
}
}
*/