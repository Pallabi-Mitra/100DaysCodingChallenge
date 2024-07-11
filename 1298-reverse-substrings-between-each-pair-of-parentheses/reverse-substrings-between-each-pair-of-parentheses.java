class Solution {
    public String reverseParentheses(String s) {

        // While there are parentheses in the string
    while (s.contains("(")) {
        // Find the innermost '('
        int start = s.lastIndexOf("(");
        // Find the matching ')'
        int end = s.indexOf(")", start);
        // Reverse the substring inside the parentheses
        String reversed = new StringBuilder(s.substring(start + 1, end)).reverse().toString();
        // Replace the parentheses with the reversed substring
        s = s.substring(0, start) + reversed + s.substring(end + 1);
    }
    // Return the resulting string
    return s;



        
    }
}