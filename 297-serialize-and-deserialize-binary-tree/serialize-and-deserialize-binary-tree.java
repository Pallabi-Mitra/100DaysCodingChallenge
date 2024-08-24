/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null)
            return "";
        
        Queue<TreeNode> q = new LinkedList<>();

        StringBuilder res = new StringBuilder();

        q.add(root); 

        while(!q.isEmpty())
        {
            TreeNode node = q.poll();

            if(node == null)
            {
                res.append("n "); // delimeter to denote null can use hash as well
                continue;
            }

            res.append(node.val +" ");// if not null append the value as string and separate by space
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data =="") return null;

        Queue<TreeNode> q = new LinkedList<>();

        String[] values = data.split(" ");//separating every node

        TreeNode root = new TreeNode(Integer.parseInt(values[0])); // first value of node is root

        q.add(root);

        for(int i=1;i< values.length;i++)
        {
            TreeNode parent = q.poll();

            if(!values[i].equals("n")) // not null
            {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));// new node with next value
                parent.left=left;
                q.add(left);
            }

            if(!values[++i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
            // if n it will point null
        }


        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));