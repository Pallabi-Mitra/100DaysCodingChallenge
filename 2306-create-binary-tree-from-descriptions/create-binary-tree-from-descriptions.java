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
    public TreeNode createBinaryTree(int[][] descriptions) {


  Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();
        
        // Populate the nodeMap and childSet
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            if (!nodeMap.containsKey(parent)) {
                nodeMap.put(parent, new TreeNode(parent));
            }
            if (!nodeMap.containsKey(child)) {
                nodeMap.put(child, new TreeNode(child));
            }

            TreeNode parentNode = nodeMap.get(parent);
            TreeNode childNode = nodeMap.get(child);

            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            childSet.add(child);
        }
        
        // Find the root (a node which is not a child of any other node)
        TreeNode root = null;
        for (int[] desc : descriptions) {
            if (!childSet.contains(desc[0])) {
                root = nodeMap.get(desc[0]);
                break;
            }
        }
        
        return root;
    }
}