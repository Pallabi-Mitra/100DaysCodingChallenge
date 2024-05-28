class Solution {
    public int myAtoi(String s) {

   // Initializing variables
        int i = 0, result = 0, sign = 1;
        int n = s.length();
        
        // Skip leading whitespace
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        
        // Check for optional sign
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Process digits and form the integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Check for overflow/underflow before adding the digit
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        // Apply the sign
        return result * sign;
    


    

    
        
    }
}