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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {


        
       // Convert to_delete array to a set for O(1) look-up times
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        
        // List to store the resulting roots
        List<TreeNode> forest = new ArrayList<>();
        
        // Helper function to traverse and delete nodes
        root = helper(root, toDeleteSet, forest);
        
        // If the root itself is not deleted, add it to the forest
        if (root != null) {
            forest.add(root);
        }
        
        return forest;
    }

    private TreeNode helper(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }

        // Recur for left and right children
        node.left = helper(node.left, toDeleteSet, forest);
        node.right = helper(node.right, toDeleteSet, forest);
        
        // If current node needs to be deleted
        if (toDeleteSet.contains(node.val)) {
            // If left child exists, add it to forest
            if (node.left != null) {
                forest.add(node.left);
            }
            // If right child exists, add it to forest
            if (node.right != null) {
                forest.add(node.right);
            }
            // Return null to delete the current node
            return null;
        }
        
        return node;
    }
}
