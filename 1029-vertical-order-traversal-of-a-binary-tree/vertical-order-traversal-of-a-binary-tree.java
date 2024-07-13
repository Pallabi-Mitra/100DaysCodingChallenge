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
 // Level Order Traversal




 /*
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        traverseTree(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> yMap : map.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            result.add(column);
        }

        return result;
    }

    private void traverseTree(TreeNode node, int row, int col, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;
        
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(node.val);
        
        traverseTree(node.left, row + 1, col - 1, map);
        traverseTree(node.right, row + 1, col + 1, map);
    }
}
    */


    class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {


       
        List<int[]> nodes = new ArrayList<>(); // List to store nodes with their positions
        traverseTree(root, 0, 0, nodes); // Traverse the tree and collect node positions
        
        // Sort nodes by column, row, and then value
        Collections.sort(nodes, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; // Sort by column
            if (a[2] != b[2]) return a[2] - b[2]; // Sort by row
            return a[0] - b[0]; // Sort by value
        });

        List<List<Integer>> result = new ArrayList<>();
        int lastColumn = Integer.MIN_VALUE;
        
        // Group nodes by column to form the result
        for (int[] node : nodes) {
            if (node[1] != lastColumn) {
                lastColumn = node[1];
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(node[0]);
        }
        
        return result;
    }

    private void traverseTree(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) return; // Base case: if the node is null, return
        nodes.add(new int[]{node.val, col, row}); // Add the node value and its position to the list
        traverseTree(node.left, row + 1, col - 1, nodes); // Traverse the left subtree
        traverseTree(node.right, row + 1, col + 1, nodes); // Traverse the right subtree
    }
}