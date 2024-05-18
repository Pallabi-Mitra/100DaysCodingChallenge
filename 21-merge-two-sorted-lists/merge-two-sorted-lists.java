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

    // Iterative :
     
 public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

   
        if(head1==null)return head2;
        if(head2==null) return head1;

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        ListNode dummyNode = new ListNode(-1);

        ListNode res = dummyNode;

        while(temp1!=null && temp2!=null)
        {
            if(temp1.val<temp2.val)
            {
                res.next=temp1;
                res=temp1;
                temp1=temp1.next;
            }
            else 
            {
                res.next=temp2;
                res=temp2;
                temp2=temp2.next;
            }
           
        }
        while(temp1!=null)
        {
            res.next=temp1;
            res=temp1;
            temp1=temp1.next;
        }
        while(temp2!=null)
        {
            res.next=temp2;
            res=temp2;
            temp2=temp2.next;
        }
        
        return dummyNode.next;
  
}
}

     
    
    


    // Recursion :

     // Recursion : 
     /*
public ListNode merge(ListNode head1, ListNode head2) {
 

        if(head1==null)return head2;
        if(head2==null)return head1;

        if(head1.val<head2.val)
        {
            head1.next=merge(head1.next,head2);
            return head1;
        }
        else
        {
            head2.next=merge(head1,head2.next);
            return head2;
        }


}
 public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

   return merge(head1,head2);
 }
*/