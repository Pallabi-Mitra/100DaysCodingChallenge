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
        
// Optimized : O(n1 + n2)

if(headA == null || headB ==null) return null;

ListNode temp1 = headA;
ListNode temp2 = headB;

    while(temp1!= temp2)
    {
        temp1 = temp1.next;
        temp2=temp2.next;

        if(temp1 == temp2) return temp1;

        if(temp1 == null) temp1= headB;
        if(temp2 == null) temp2= headA;

    }
    return temp1;

    }
}











// Better:O(n1 + 2n2)
/*
int n1= 0; // counting elements in LL1
int n2=0; // counting elements in LL2

    ListNode temp = headA;

    while(temp!=null) // counting the total no of nodes in LL1
    {
        n1++;
        temp=temp.next;
    }
    temp=headB;

while(temp!=null) // counting the total no of nodes in LL2
    {
        n2++;
        temp=temp.next;
    }

    if(n1<n2) // if LL2 is larger 
// we send the smaller head first
        return intersectionPoint(headA,headB,n2-n1); //smaller head,larger head,diff
    else // LL1 is larger
        return intersectionPoint(headB,headA,n1-n2); 
    }

    public ListNode intersectionPoint(ListNode headA,ListNode headB,int diff)
    {
        // second head is larger so move it by diff dist:

        while(diff!=0)
        {
            headB= headB.next; // we move the LL which is greater by diff so that we can 
            //start traversing the shorter LL and larger LL from same node
            diff--; 
        }

        ListNode tempA = headA;
        ListNode tempB = headB;
//
        while(tempA!=null && tempB !=null)
        {
            if(tempA==tempB)
                return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }

//
// another way of looping : 
    while(tempA!=tempB) // untill found same node keep traversing
    {
         tempA=tempA.next;
        tempB=tempB.next;
    }
    return tempA;// when found same return
    }



}

*/
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