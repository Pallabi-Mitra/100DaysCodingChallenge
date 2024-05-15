/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
// Optimized:

int n1= 0;
int n2=0;

    ListNode temp = headA;

    while(temp!=null)
    {
        n1++;
        temp=temp.next;
    }
    temp=headB;

while(temp!=null)
    {
        n2++;
        temp=temp.next;
    }

    if(n1<n2)
        return intersectionPoint(headA,headB,n2-n1); //smaller head,larger head,diff
    else
        return intersectionPoint(headB,headA,n1-n2); 
    }

    public ListNode intersectionPoint(ListNode headA,ListNode headB,int diff)
    {
        // second head is larger so move it by diff dist:

        while(diff!=0)
        {
            headB= headB.next;
            diff--;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA!=null && tempB !=null)
        {
            if(tempA==tempB)
                return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }

    return null;
    }



}


        // Bruteforce : Hashing :
        /*
        if(headA==null|| headB==null )return null;

        ListNode temp = headA;

        HashMap<ListNode,Integer> mpp = new HashMap<>();

        while(temp!=null)
        {
           
            mpp.put(temp,1);
            temp=temp.next;
        }

        temp=headB;

        while(temp!=null)
        {
            if(mpp.containsKey(temp))
            {
                return temp;
            }
            temp=temp.next;
        }

        return null;
    }
}

*/