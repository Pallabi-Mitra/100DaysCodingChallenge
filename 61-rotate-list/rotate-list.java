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

    public ListNode findNthNode(ListNode temp,int k)
    {
        int cnt = 1;
        
        while(temp!=null)
        {
          if(cnt==k) return temp;
           cnt++;
            temp=temp.next;
        }
        return temp;
    }


    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || k==0) return head;
        ListNode tail = head;
        int length = 1;
        while(tail.next!=null)
        {
            
            tail=tail.next;
            length++;
        }

        if(k%length==0)
        {
            return head;
        }
       
        k= k%length;
         tail.next=head;
       
       ListNode newLastNode = findNthNode(head,length-k);

       head=newLastNode.next;

       newLastNode.next=null;
       
       return head;
        
    }
}