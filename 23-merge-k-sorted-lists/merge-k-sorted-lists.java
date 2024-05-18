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
    public ListNode mergeKLists(ListNode[] lists) {

        // Bruteforce :

     List<ListNode> nodeList = new ArrayList<>();
        
        // Collect all nodes into the list
        for (ListNode list : lists) {
            while (list != null) {
                nodeList.add(list);
                list = list.next;
            }
        }
        
        // Sort the list based on node values
        Collections.sort(nodeList, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        
        // Create a new sorted linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (ListNode node : nodeList) {
            current.next = node;
            current = current.next;
        }
        current.next = null;  // Set the last node's next to null
        
        return dummy.next;

        



        
    }
}