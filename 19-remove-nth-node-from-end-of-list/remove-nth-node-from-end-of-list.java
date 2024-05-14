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

// Bruteforce : 

    ListNode temp= head;
    int cnt = 0;
    while(temp!=null)
    {
        cnt++;
        temp=temp.next;
    }

    if(cnt == n)
    {
        ListNode newhead = head.next;
        head=null;
        return newhead;
    }
    
    temp=head;
    int res= cnt-n;
    while(temp!=null)
    {
        res--;
        if(res==0)
        {
            break;
           
        }
        temp=temp.next;
    }
     temp.next=temp.next.next;

return head;
    }
}


     /*   
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
         while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        ListNode delNode = slow.next;
        slow.next=slow.next.next;
        return head;
    }
}

*/