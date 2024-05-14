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
    public ListNode deleteMiddle(ListNode head) {


// Optimized :tortoise hare algorithm

if(head==null || head.next==null) return null;
ListNode slow= head;
ListNode fast=head;

int cnt = 0;

    while(fast!=null && fast.next!=null)
    {
        if(cnt==0)
        {
            fast=fast.next.next;
            cnt++;
        }
        else
        {
 slow=slow.next;
        fast=fast.next.next;
        }
       
       
    }
    slow.next=slow.next.next;

    return head;
    }
}


//Bruteforce :
/*
        if(head==null)return head; // no node
        ListNode temp= head;
        int cnt = 0;

        while(temp!=null)
        {
            cnt++;
            temp=temp.next;
        }
        if(cnt==1) // if head
        {
            head=head.next;
            return head;
        }

        double res = Math.floor(cnt/2);


        temp=head;
        while(temp!=null)
        {
            res--;
            if(res==0) // to reach to the node before the middle node to be deleted
            break;

            temp=temp.next;
        }

        temp.next=temp.next.next; // delete the node, point the prev node to the next 
        return head;
    }
}
*/