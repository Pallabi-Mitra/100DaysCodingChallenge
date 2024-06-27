class Solution {
    public int findCenter(int[][] edges) {

        // Get the first and second edge
    int[] edge1 = edges[0];
    int[] edge2 = edges[1];
    
    // Compare the nodes of the first edge with the nodes of the second edge
    if (edge1[0] == edge2[0] || edge1[0] == edge2[1]) {
        return edge1[0];
    } else {
        return edge1[1];
    }
        
    }
}