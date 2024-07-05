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
     private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // Start the depth calculation and diameter update process
        calculateDepth(root);
        // Return the maximum diameter found
        return diameter;
        
    }

    // Helper function to calculate depth and update diameter
    private int calculateDepth(TreeNode node) {
        // If node is null, return 0 as the depth
        if (node == null) {
            return 0;
        }

        // Recursively calculate the depth of the left subtree
        int leftDepth = calculateDepth(node.left);
        // Recursively calculate the depth of the right subtree
        int rightDepth = calculateDepth(node.right);

        // Update the diameter if the current path is larger than the current diameter
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return the depth of the tree rooted at the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}