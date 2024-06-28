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

 // Using 1 stack : 


    class Solution {

        public List<Integer> postorderTraversal(TreeNode root) {
    // List to store the postorder traversal
    List<Integer> result = new ArrayList<>();
    
    // Check if the root is null
    if (root == null) {
        return result;
    }
    
    // Stack to store the nodes for processing
    Stack<TreeNode> stack = new Stack<>();
    
    // Push the root node to the stack
    stack.push(root);
    
    // Loop while the stack is not empty
    while (!stack.isEmpty()) {
        // Pop a node from the stack
        TreeNode node = stack.pop();
        
        // Add the node's value to the result list
        result.add(node.val);
        
        // Push the left child to the stack if it exists
        if (node.left != null) {
            stack.push(node.left);
        }
        
        // Push the right child to the stack if it exists
        if (node.right != null) {
            stack.push(node.right);
        }
    }
    
    // Reverse the result list to get the postorder traversal
    Collections.reverse(result);
    
    return result;
    }
    }

 /*

// Using 2 stacks - Iterative Solution TC : o(n)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {


        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();

        List<Integer> postOrder = new ArrayList<Integer>();

        if(root == null) return postOrder;


        st1.push(root);

        while(!st1.isEmpty())
        {
            root = st1.pop();
            st2.add(root);
            if(root.left!=null) st1.push(root.left);
            if(root.right!=null) st1.push(root.right);
        }

        while(!st2.isEmpty())
        {
            postOrder.add(st2.pop().val);
        }
        



        return postOrder;


    }
}

*/

 // Using Recursion :

 /*
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> al = new ArrayList<>();

        postOrder(root,al);
        return al;
        
    }

    public void postOrder(TreeNode root,List<Integer> al)
    {
        if(root==null)
            return;

        postOrder(root.left,al);
        postOrder(root.right,al);
        al.add(root.val);
    }
}

*/