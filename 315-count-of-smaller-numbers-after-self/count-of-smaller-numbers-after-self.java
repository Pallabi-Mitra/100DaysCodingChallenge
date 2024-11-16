
class Solution {
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> counts = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = findInsertPosition(sorted, nums[i]);
            counts.add(pos);
            sorted.add(pos, nums[i]);
        }
        
        Collections.reverse(counts);
        return counts;
    }
    
    private int findInsertPosition(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sorted.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
