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
    public ListNode sortList(ListNode head) {

// Bruteforce : 

    ListNode temp = head;
    ArrayList<Integer> al = new ArrayList<>();

    while(temp!=null)
    {
        al.add(temp.val);
        temp=temp.next;
    }

    Collections.sort(al);
    temp = head;
    int i = 0;
    while(temp!=null)
    {
        temp.val=al.get(i);
        i++;
        temp=temp.next;

    }

    return head;
    }
}


















// Optimized : 
/*
        ListNode before = head;
        ListNode after = head;
        ListNode temp;

        while(after!=null && before!=null)
        {
            if(before.val>after.val)
            {
                temp = before;
                before=after;
                after=temp;
            }
            before=before.next;
            after=after.next;
        }

        return head;
        
    }
}

*/