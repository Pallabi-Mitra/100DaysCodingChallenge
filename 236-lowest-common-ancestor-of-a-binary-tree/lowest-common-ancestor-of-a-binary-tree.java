/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

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
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {

        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        if(!findPath(root,path1,n1)|| !findPath(root,path2,n2))
        {
            return null;
        }

        // Find the intersection from the arraylists:

        int i;
        for(i=0;i< path1.size() && i< path2.size();i++)
        {
            if(!path1.get(i).equals(path2.get(i)))
            {
                    break;
            }
        }

        return path1.get(i-1); // last common node in the two path will be LCA
        

    }
}