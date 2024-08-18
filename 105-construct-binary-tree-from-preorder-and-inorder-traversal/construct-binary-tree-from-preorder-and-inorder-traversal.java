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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
 return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    
        
    }
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
    // Base case: if the start index is greater than end index, return null (no tree to build)
    if (inStart > inEnd) return null;

    // The current root is the first element of preorder
    TreeNode root = new TreeNode(preorder[preStart]);

    // Find the index of this root in the inorder array
    int inIndex = 0;
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
            break;
        }
    }

    // Recursively build the left subtree
    root.left = buildTreeHelper(preorder, inorder, preStart + 1, inStart, inIndex - 1);

    // Recursively build the right subtree
    root.right = buildTreeHelper(preorder, inorder, preStart + (inIndex - inStart) + 1, inIndex + 1, inEnd);

    return root;

}
}