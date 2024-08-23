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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder == null || postorder == null || inorder.length!= postorder.length)
            return null;

        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i=0;i<inorder.length;++i)
            hm.put(inorder[i],i); // putting all inorder in map

            return buildTreePostIn(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
    
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder,int ps,int pe,HashMap<Integer,Integer> hm)
    {
        if(ps>pe || is>ie) return null; //no more left or right subarray left

        TreeNode root = new TreeNode(postorder[pe]); // taking the last node of postorder as root

        int inRoot = hm.get(postorder[pe]); // getting the root node from inorder 

        int numsLeft = inRoot -is; // starting of left subtree

        // calling the func recursively to build the left subtree same way
        // range of nodes are 
        root.left = buildTreePostIn(inorder,is,inRoot-1,postorder,ps,ps+numsLeft-1,hm);

        root.right = buildTreePostIn(inorder,inRoot+1,ie,postorder,ps+numsLeft,pe-1,hm);
        return root;

    }


}