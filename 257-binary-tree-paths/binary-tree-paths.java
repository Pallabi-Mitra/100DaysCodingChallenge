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

 // Recursive Call :

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {


        /*

        List<String> ans = new ArrayList<>();

        if(root ==null)
        {
            return ans; // return an empty list
        }

        return checkPath(root,ans);
  
    }

    public List<String> checkPath(TreeNode root, List<String> ans)
    {

        // base condition :

        if(root.left ==null && root.right ==null) // leaf node
        {
           return ans.add(root);
        }

        ans.add(root);




    }
}
*/
// Iterative way :
 List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair<>(root, String.valueOf(root.val)));

        while (!stack.isEmpty()) {
            Pair<TreeNode, String> current = stack.pop();
            TreeNode node = current.getKey();
            String path = current.getValue();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.right != null) {
                    stack.push(new Pair<>(node.right, path + "->" + node.right.val));
                }
                if (node.left != null) {
                    stack.push(new Pair<>(node.left, path + "->" + node.left.val));
                }
            }
        }

        return paths;
    }

    // Pair class to hold node and path string
    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

