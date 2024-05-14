/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

//Bruteforce : Using Hashing


    HashMap<ListNode,Integer> mpp = new HashMap<>();

    ListNode temp = head;

    while(temp!=null)
    {
        if(mpp.containsKey(temp))
        {
            return true;
        }
        mpp.put(temp,1);
        temp=temp.next;
    }
    return false;
    }
}




/* Optimized :

        ListNode slow=head;
        ListNode fast=head;

       
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;

            
        }   
        return false;  


    }
}
*/