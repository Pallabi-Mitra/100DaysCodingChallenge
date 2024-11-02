class Solution {
    public String makeFancyString(String s) {


        // method 1 :
        
         // Create a StringBuilder to store the result (acts like a stack here).
    StringBuilder result = new StringBuilder();
    
    // Traverse each character in the string.
    for (int i = 0; i < s.length(); i++) {
        char currentChar = s.charAt(i);
        
        // Check if the last two characters in the result are the same as the current character.
        int len = result.length();
        if (len >= 2 && result.charAt(len - 1) == currentChar && result.charAt(len - 2) == currentChar) {
            continue; // Skip this character if it creates three consecutive identical characters.
        }
        
        // Otherwise, add the current character to the result.
        result.append(currentChar);
    }
    
    // Convert StringBuilder back to string and return.
    return result.toString();
    }
}