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
    public ListNode removeNthFromEnd(ListNode head, int n) {



    //    Optimized :


        ListNode fast= head;
        ListNode slow = head;

        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }

       
        if(fast==null)
        {
            ListNode newHead = head.next;
            return newHead;
        }
         while(fast.next!=null) // last node
        {
            slow=slow.next;
            fast=fast.next;
        }
       // ListNode delNode = slow.next;
        slow.next=slow.next.next;
        return head;
    }
}

/*
// Bruteforce : 

    ListNode temp= head;
    int cnt = 0;
    while(temp!=null)
    {
        cnt++; // getting the length of the LL
        temp=temp.next;
    }

    if(cnt == n) // if head is asked to delete
    {
        ListNode newhead = head.next;
        head=null;
        return newhead;
    }
    
    temp=head;
    int res= cnt-n; // we get the node 1  before we need to delete
    while(temp!=null)
    {
        res--;// we traverse the LL till the node
        if(res==0)
        {
            break;
           
        }
        temp=temp.next;
    }
     temp.next=temp.next.next; //  we make the node point to one node ahead, deleting the 
     // middle skipped node which was asked to be deleted

return head;
    }
}
*/
