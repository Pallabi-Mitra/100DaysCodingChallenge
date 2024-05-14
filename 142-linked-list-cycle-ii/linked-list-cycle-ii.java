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
    public ListNode detectCycle(ListNode head) {


        // Bruteforce : Hashing


        HashMap<ListNode,Integer> mpp = new HashMap<>();

        ListNode temp = head;
       // int freq=0;
      // int val = 0;

        while(temp!=null)
        {
           
            if(mpp.containsKey(temp))
            {
                if(mpp.get(temp)!=null)
                {
                         return temp;
                }
               
            }
          
            mpp.put(temp,1);
           
            temp=temp.next;
        }
        return null;
        
    }
}