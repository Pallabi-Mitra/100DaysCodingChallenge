/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    

    public ListNode reverseLinkedList(ListNode head)
    {   

        ListNode prev = null;
        ListNode temp = head;
        
        while(temp!=null)
        {
            ListNode after = temp.next;
            temp.next=prev;
            prev=temp;
            temp=after;
        }
        return prev;
    }
    public ListNode getKthNode(ListNode temp, int k)
    {
        // traversing till the Kth node, returning that node
       k-=1;// head is passed, traversing after that
      
        while(temp!=null && k>0 )
        {
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;

        ListNode prevLast = null; // to store the previous node

        while(temp!=null)
        {
            ListNode kThNode = getKthNode(temp,k); // get the Kth node
            if(kThNode == null) // no Kth node present
            {
                if(prevLast!=null) // if prev is not null, like in case of 1 node or 2 node LL
                {
                 prevLast.next=temp; // make the rest nodes point to get them attached
                
                }

                 break;
            }
            else
            {

            
        

            ListNode nextNode = kThNode.next; // make the next node of kth as next
            kThNode.next=null; // make the Kth node next null, to end the Kth LL

            reverseLinkedList(temp); // reverse LL, it has the head of reversed LL, = Kth Node

            if(temp==head) // first group, first time traversal// upon reverse
            {
                    head = kThNode; // first KThNode will always be the new head
            }
            else
            {
                prevLast.next=kThNode; // make previous point to 
            }
            prevLast=temp; // Kthnod
            temp = nextNode;// move the temp to start new cycle
            }

        }

        return head; // reversed joined LL
        
    }
}
