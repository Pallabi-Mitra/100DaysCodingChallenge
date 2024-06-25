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
    private int sum = 0; // This will store the cumulative sum of node values.

    public TreeNode bstToGst(TreeNode root) {
        // Start the reverse in-order traversal from the root
        reverseInOrderTraversal(root);
        return root; // Return the modified tree
    }

    private void reverseInOrderTraversal(TreeNode node) {
        // Base case: if the node is null, return immediately
        if (node == null) return;
        
        // Recur on the right subtree first (nodes with greater values)
        reverseInOrderTraversal(node.right);
        
        // Process the current node
        sum += node.val; // Add the current node's value to the cumulative sum
        node.val = sum; // Update the current node's value to the cumulative sum
        
        // Recur on the left subtree next (nodes with smaller values)
        reverseInOrderTraversal(node.left);
    }
}
