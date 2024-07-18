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

 List<String> ans = new ArrayList<>();

        if(root ==null)
        {
            return ans; // return an empty list
        }

        checkPath(root,"",ans); // TreeNode root, String path, List<String> ans
        return ans;
  
    }

    public void checkPath(TreeNode root, String path, List<String> ans)
    {

        // base condition :
/*
        if(root.left ==null && root.right ==null) // leaf node
        {
           return ans.add(root);
        }
*/

        if(root ==null) // base condition 
        {
            return ;
        }

        //Append current node's value to the path :

        path+= root.val;

        // Check if the current node is a leaf node :

        if(root.left ==null && root.right ==null) // leaf node
        {

            // Add the path to the List
            ans.add(path);
        }
        else
        {
            //If not a leaf node, append a '->' and recurse
            path+= "->";
            checkPath(root.left,path,ans);
            checkPath(root.right,path,ans);
        }

      
    }
}


// Iterative way :
/*
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

*/

/*


binaryTreePaths: Uses an iterative depth-first search (DFS) with a stack to avoid recursion.
Pair class: Holds a TreeNode and the current path string.
binaryTreePaths:
Initializes a stack and pushes the root node along with its value as the initial path.
Iterates until the stack is empty.
Pops the current node and path from the stack.
If the node is a leaf, adds the path to the paths list.
Otherwise, pushes the right and left children onto the stack with the updated path.
Dry Run with Example Input: [1, 2, 3, null, 5]
Start with root node 1.
Push (1, "1") onto the stack.
Pop (1, "1"), push (3, "1->3") and (2, "1->2").
Pop (2, "1->2"), push (5, "1->2->5").
Pop (5, "1->2->5"), add "1->2->5" to paths.
Pop (3, "1->3"), add "1->3" to paths.
*/