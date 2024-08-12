class KthLargest {

  private int k;
    private ArrayList<Integer> nums;
    public KthLargest(int k, int[] nums) {
          this.k = k;
    
        this.nums = new ArrayList<>();
        for (int num : nums) {
            this.nums.add(num);
        }
    }
    
    public int add(int val) {
          nums.add(val); // Add the new value to the list
        Collections.sort(nums, Collections.reverseOrder()); // Sort the list in descending order
        return nums.get(k - 1); // Return the kth largest element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */