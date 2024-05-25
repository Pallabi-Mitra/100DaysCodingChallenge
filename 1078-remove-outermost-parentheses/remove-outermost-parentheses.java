class Solution {
    public String removeOuterParentheses(String s) {
        
        // Initialize counter to keep track of the balance of parentheses
    int count = 0;
    // StringBuilder to construct the result string
    StringBuilder result = new StringBuilder();
    
    // Iterate through each character in the input string
    for (char c : s.toCharArray()) {
        // If character is ')', decrement count first
        if (c == ')') count--;
        // If count is not zero, it means it's not an outer parenthesis
        if (count > 0) result.append(c);
        // If character is '(', increment count after processing
        if (c == '(') count++;
    }
    
    // Convert StringBuilder to String and return
    return result.toString();

    }
}
