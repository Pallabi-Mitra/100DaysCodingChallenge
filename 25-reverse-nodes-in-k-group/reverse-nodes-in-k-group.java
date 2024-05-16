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
       k-=1;
        while(temp!=null && k>0)
        {
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;

        ListNode prevLast = null;

        while(temp!=null)
        {
            ListNode kThNode = getKthNode(temp,k);
            if(kThNode == null)
            {
                if(prevLast!=null)
                {
                 prevLast.next=temp;
                
                }

                 break;
            }
        

            ListNode nextNode = kThNode.next;
            kThNode.next=null;

            reverseLinkedList(temp);

            if(temp==head) // first group, first time traversal// upon reverse
            {
                    head = kThNode; // first KThNode will always be the new head
            }
            else
            {
                prevLast.next=kThNode;
            }
            prevLast=temp;
            temp = nextNode;

        }

        return head;
        
    }
}
