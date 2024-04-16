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
    public ListNode reverseList(ListNode head) {

        ListNode before = null; 
        ListNode temp = head;
        /*ListNode tail;
        
        temp = head;
        head=tail;
        tail=temp;*/
        ListNode after; 


       
        while(temp!=null)
        {
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;



        }
        return before;
        
    }
}