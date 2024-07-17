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