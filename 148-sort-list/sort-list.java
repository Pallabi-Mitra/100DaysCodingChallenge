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
 /*
class Solution {
    


// Optimized : Merge Sort on LL :


public ListNode findMiddle(ListNode head)
{
    ListNode slow= head;
    ListNode fast=head.next; // to get the 1st mid

    while(fast!=null && fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;

}

public ListNode mergeTwoLists(ListNode list1, ListNode list2)
{
    ListNode dummyNode = new ListNode(0);
    ListNode temp = dummyNode;


    while(list1!=null && list2!=null)
    {
        if(list1.val<list2.val)
        {
            temp.next=list1;
            list1=list1.next;
        }
        else
        {
            temp.next=list2;
            list2=list2.next;
        }
    }
   temp.next = (list1!=null)? list1 : list2;
    return dummyNode.next;
}

public ListNode sortList(ListNode head) {

if(head==null || head.next==null) return head;

    ListNode middle = findMiddle(head);
    ListNode right= middle.next;
    middle.next= null;
    ListNode left = head;

    left=sortList(left);
    right=sortList(right);

    return mergeTwoLists(left,right);
}
}

*/
public class Solution {
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);
        ListNode newHead = mid.next;
        mid.next = null;
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(newHead);
        return merge(leftHalf, rightHalf);
    }
}







// Bruteforce : 
/*
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

*/


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