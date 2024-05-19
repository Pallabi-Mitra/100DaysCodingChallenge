class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int result[] = new int[n];

        for (int i = 2*n; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty() == false) {
                    result[i] = st.peek();
                } else {
                    result[i] = -1;
                }
            }

            st.push(nums[i % n]);
        }

        return result;
    }
}