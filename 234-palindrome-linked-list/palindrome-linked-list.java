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

    public ListNode reverse(ListNode slow)
    {
       // ListNode temp = slow;
        ListNode prev=null;
    
    while(slow!=null)
    {
        ListNode after = slow.next;
        slow.next=prev;
        prev=slow;
        slow=after;
    }
    return prev;

    }
    public boolean isPalindrome(ListNode head) {

// Optimized : tortoise hare 


    // find the middle of LL :

    ListNode slow = head;
    ListNode fast = head;

    while(fast.next!= null && fast.next.next!=null)
    {
        slow= slow.next;
        fast=fast.next.next;
    }

    ListNode newhead = reverse(slow.next);
    
    ListNode left = head;
    ListNode right=newhead;

while(right!=null)
{
    if(left.val!=right.val)
    {
        reverse(newhead);
        return false;
    }
    left=left.next;
    right=right.next;
}
   reverse(newhead); 

    return true;




    }
}


// Bruteforce : Using Stack : 
/*
Stack<Integer> st = new Stack<>();

ListNode temp = head;

// store all linkedlist data to stack : 
while(temp!=null)
{
    st.push(temp.val);
    temp=temp.next;



}
temp = head;
while(temp!=null)

{
    if(temp.val != st.peek())
    return false;

    st.pop();
    temp=temp.next;
}
return true;
    }

}
*/
        // code converting into no and checking : all testcases not passed :
        /*

        ListNode temp = head;
        long sum = 0;
        int value=0;

        while(temp!=null)
        {
            value = temp.val;

            sum=(sum*10)+value;
            temp=temp.next;
        }
        long num = sum;
        long r=0;
        long summation=0;
        while(num!=0)
        {
            r= num%10;
            summation=(summation*10)+r;
            num=num/10;
        }

        if(summation==sum)
            return true;
        else
        return false;


        
    }
}
*/