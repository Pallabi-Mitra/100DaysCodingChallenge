class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
          // Create a min-heap for projects based on capital required
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Create a max-heap for available projects based on profit
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        // Fill the min-heap with project details
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[] { capital[i], profits[i] });
        }
        
        // Iterate up to k times to pick the best projects
        for (int i = 0; i < k; i++) {
            // Add all projects that can be started with current capital to the max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }
            
            // If no projects can be started, break the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            
            // Select the project with the maximum profit
            w += maxProfitHeap.poll();
        }
        
        // Return the final capital
        return w;
    }
}