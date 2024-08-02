/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
 // BruteForce Solution :
class Solution {


    public boolean findPath(TreeNode root,ArrayList<TreeNode>path,TreeNode n)
    {

    // Function to find path from root to a given node :
        if(root ==null)
            return false;
        
        path.add(root);

        // base condition 
        if(root==n)
            return true;

        
        // if not go to left and right node :

        if(findPath(root.left,path,n) || findPath(root.right,path,n))
        {
            return true; // if matching node found in either left / right subtree
        }

// else the node is not present remove it from ds and return false
        path.remove(path.size()-1);
        return false;// no path
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {

        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        if(!findPath(root,path1,n1)|| !findPath(root,path2,n2))// if either is returned false
        {
            return null;
        }
// if true means path is present now find the LCA between the two nodes :
        // Find the intersection from the arraylists:

        int i;
        for(i=0;i< path1.size() && i< path2.size();i++)
        {
            if(!path1.get(i).equals(path2.get(i))) // the point of mismatch , we need the prev value from here
            {
                    break;
            }
        }

        return path1.get(i-1); // last common node in the two path will be LCA
        

    }
}

*/

// Recursive Method :

class Solution
{
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q)
    {
        // base case :
        if(root == null || root ==p || root ==q)
        {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        // result

        if(left==null)
        {
            return right;
        }

        else if(right==null)
        {
            return left;
        }
        else
        {
            // if both left and right are not null, we found our ans
            return root;
        }


    }
}