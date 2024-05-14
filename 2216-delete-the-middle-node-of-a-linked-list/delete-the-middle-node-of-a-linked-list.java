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

        if(head==null)return head;
        ListNode temp= head;
        int cnt = 0;

        while(temp!=null)
        {
            cnt++;
            temp=temp.next;
        }
        if(cnt==1)
        {
            head=head.next;
            return head;
        }

        double res = Math.floor(cnt/2);


        temp=head;
        while(temp!=null)
        {
            res--;
            if(res==0)
            break;

            temp=temp.next;
        }

        temp.next=temp.next.next;
        return head;
    }
}