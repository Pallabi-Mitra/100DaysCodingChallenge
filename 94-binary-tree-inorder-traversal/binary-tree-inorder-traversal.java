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
    public List<Integer> inorderTraversal(TreeNode root) {
           // List to store the
        // inorder traversal result
        ArrayList<Integer> al = new ArrayList<>();
       // Pointer to the current node,
        // starting from the root
         TreeNode curr = root; 
         // Loop until the current
        // node is not NULL
        while(curr!= null)
        {
             // If the current node's
            // left child is NULL
            if(curr.left==null)
            {
                // Add the value of the current
                // node to the inorder list
                al.add(curr.val); // if no left print the curr that is root and move right
                 // Move to the right child
                curr = curr.right;
            }
            else // if there exists a left
            {
                 // If the left child is not NULL,
                // find the predecessor (rightmost node
                // in the left subtree)

                // go to last node of the left subtree
                // go to the left, go to the rightmost guy
                TreeNode prev = curr.left; 
                while(prev.right!= null && prev.right!=curr) // go to the right and right not pointing to itself
                {
                    prev = prev.right;
                }

                //1st case :
                    // If the predecessor's right child
                // is NULL, establish a temporary link
                // and move to the left child
                if(prev.right == null) // last node so create the thread

                {
                    prev.right = curr; // thread pointing to root
                    // inorder.add(curr.val); // for preorder traversal
                    curr = curr.left; // do the traversal
                }
                else 
                {
                     // If the predecessor's right child
                    // is already linked, remove the link,
                    // add current node to inorder list,
                    // and move to the right child
                 prev.right = null;
                 al.add(curr.val);
                 curr = curr.right;   
                }
            }
        }
        // Return the inorder
        // traversal result
        return al;
    }
}