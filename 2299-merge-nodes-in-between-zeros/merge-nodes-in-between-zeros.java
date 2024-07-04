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
    public ListNode mergeNodes(ListNode head) {
          // Dummy node to simplify handling the new list
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    ListNode temp = head.next; // Skip the initial zero
    int sum = 0;

    // Traverse the linked list
    while (temp != null) {
        if (temp.val != 0) {
            sum += temp.val; // Add the value to sum
        } else {
            if (sum != 0) {
                current.next = new ListNode(sum); // Create a new node with the sum
                current = current.next; // Move the current pointer
                sum = 0; // Reset the sum
            }
        }
        temp = temp.next; // Move to the next node
    }
    return dummy.next;
    }
}