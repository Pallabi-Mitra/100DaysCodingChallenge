class Solution {
    public int minKBitFlips(int[] nums, int k) {

        int n = nums.length;
    int flips = 0, currentFlips = 0;
    Queue<Integer> flipQueue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
        if (!flipQueue.isEmpty() && flipQueue.peek() == i) {
            flipQueue.poll();
            currentFlips ^= 1;
        }
        if ((nums[i] ^ currentFlips) == 0) {
            if (i + k > n) return -1;
            flips++;
            currentFlips ^= 1;
            flipQueue.add(i + k);
        }
    }
    return flips;
        
    }
}