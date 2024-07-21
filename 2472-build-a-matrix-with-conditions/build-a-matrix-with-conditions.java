class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        // Convert conditions to list of pairs
        List<int[]> rowConds = Arrays.asList(rowConditions);
        List<int[]> colConds = Arrays.asList(colConditions);
        
        // Get topological orders
        List<Integer> rowOrder = topologicalSort(k, rowConds);
        List<Integer> colOrder = topologicalSort(k, colConds);
        
        // Check for invalid orders
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }
        
        // Create the position maps
        Map<Integer, Integer> rowPos = new HashMap<>();
        Map<Integer, Integer> colPos = new HashMap<>();
        
        for (int i = 0; i < k; i++) {
            rowPos.put(rowOrder.get(i), i);
            colPos.put(colOrder.get(i), i);
        }
        
        // Build the matrix
        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            int r = rowPos.get(i);
            int c = colPos.get(i);
            matrix[r][c] = i;
        }
        
        return matrix;
    }

    // Function to perform topological sort
    private List<Integer> topologicalSort(int k, List<int[]> conditions) {
        // Create adjacency list and in-degree array
        List<Integer>[] adj = new ArrayList[k + 1];
        int[] inDegree = new int[k + 1];
        
        for (int i = 1; i <= k; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Build the graph
        for (int[] condition : conditions) {
            int u = condition[0], v = condition[1];
            adj[u].add(v);
            inDegree[v]++;
        }
        
        // Perform topological sorting using Kahn's Algorithm (BFS)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : adj[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // Check if the topological sort includes all nodes
        if (order.size() == k) {
            return order;
        } else {
            return new ArrayList<>();  // Invalid order, return empty list
        }
    }
        
    
}