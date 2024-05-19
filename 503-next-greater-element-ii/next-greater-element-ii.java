
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int result[] = new int[n];
// circular so 2*n to copy the array twice beside, modulo can give us the array index again
        for (int i = 2*n-1; i >= 0; i--) { // traverse from back
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop(); // if the stcak has element less than current element pop it
            }

            if (i < n) { 
                if (st.isEmpty() == false) { // if stack has elements
                    result[i] = st.peek(); // the current stack element will be the greater 
                } else {
                    result[i] = -1; // if stack empty after popping all smaller put -1 bcoz no greater element found
                }
            }

            st.push(nums[i % n]); // push all the lements in the stack
        }

        return result;
    }
}
