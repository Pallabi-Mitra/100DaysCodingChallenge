class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
        */
        
         int n = temperatures.length;
        int[] result = new int[n];
        int[] stack = new int[n]; // Using array as a stack
        int top = -1; // Index of the top element in the stack
        
        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int index = stack[top--]; // Pop the top element from the stack
                result[index] = i - index; // Calculate the days until a warmer temperature
            }
            stack[++top] = i; // Push the current index onto the stack
        }
        
        return result;
        
        
        
    }
}