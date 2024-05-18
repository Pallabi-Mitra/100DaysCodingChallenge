class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        
         int n = temperatures.length;
        int[] result = new int[n];
        int[] stack = new int[n]; // Using array as a stack
        int top = -1; // Index of the top element in the stack
        
        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int index = stack[top--]; // Pop the top element from the stack
                result[index] = i - index; // Calculate the days until a warmer temperature
            }
         //   stack[++top] = i; // Push the current index onto the stack
         top++;
         stack[top] = i;
         
        }
        
        return result;
        
        
        
    }
}