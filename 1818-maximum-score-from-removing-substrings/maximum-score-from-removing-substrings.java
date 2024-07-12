class Solution {
    public int maximumGain(String s, int x, int y) {
 // Helper function to process removals
    return x > y ? process(s, x, y, 'a', 'b') : process(s, y, x, 'b', 'a');
        
    }

    private int process(String s, int firstVal, int secondVal, char firstChar, char secondChar) {
    Stack<Character> stack = new Stack<>();
    int score = 0;

    // First pass: Remove higher priority pair
    for (char c : s.toCharArray()) {
        if (!stack.isEmpty() && stack.peek() == firstChar && c == secondChar) {
            stack.pop();
            score += firstVal;
        } else {
            stack.push(c);
        }
    }

    // Second pass: Convert remaining stack to string and process lower priority pair
    StringBuilder remainingString = new StringBuilder();
    while (!stack.isEmpty()) {
        remainingString.insert(0, stack.pop());
    }

    for (char c : remainingString.toString().toCharArray()) {
        if (!stack.isEmpty() && stack.peek() == secondChar && c == firstChar) {
            stack.pop();
            score += secondVal;
        } else {
            stack.push(c);
        }
    }

    return score;
}
}