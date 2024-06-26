/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



class Solution {
    
    // Helper method to perform in-order traversal of the BST and store the nodes in a list
    private void inOrderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;  // Base case: if the current node is null, return
        inOrderTraversal(root.left, nodes);  // Recur on the left child
        nodes.add(root.val);  // Add the current node's value to the list
        inOrderTraversal(root.right, nodes);  // Recur on the right child
    }
    
    // Helper method to construct a balanced BST from a sorted list of node values
    private TreeNode sortedListToBST(List<Integer> nodes, int start, int end) {
        if (start > end) return null;  // Base case: if the start index exceeds the end index, return null
        int mid = start + (end - start) / 2;  // Calculate the middle index
        TreeNode node = new TreeNode(nodes.get(mid));  // Create a new tree node with the middle value
        node.left = sortedListToBST(nodes, start, mid - 1);  // Recur to construct the left subtree
        node.right = sortedListToBST(nodes, mid + 1, end);  // Recur to construct the right subtree
        return node;  // Return the newly created node
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();  // Initialize a list to store the node values
        inOrderTraversal(root, nodes);  // Perform in-order traversal to fill the list with sorted node values
        return sortedListToBST(nodes, 0, nodes.size() - 1);  // Construct and return the balanced BST
    }
}
