class Solution {
    public String addStrings(String a, String b) {

// Addition Digit by Digit :

/*
StringBuilder result = new StringBuilder();
    int carry = 0;
    
    // Start adding digits from the least significant digit (rightmost)
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    
    // Continue adding digits until both numbers are fully processed
    while (i >= 0 || j >= 0 || carry > 0) {
        // Get the digit from num1 at index i, or 0 if i is out of bounds
        int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
      
        // Get the digit from num2 at index j, or 0 if j is out of bounds
        int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

       
        
        // Add digits along with carry
        int sum = digit1 + digit2 + carry;
        
        // Update carry for the next iteration
        carry = sum / 10;
        
        // Append the least significant digit of the sum to the result
        result.append(sum % 10);
        
        // Move to the next digit towards more significant digit (left)
        i--;
        j--;
    }
    
    // Reverse the result since we appended digits from least significant to most significant
    return result.reverse().toString();
    }
}
*/
StringBuilder result = new StringBuilder(); // To store the result
        int carry = 0; // Initialize carry to 0
        int i = a.length() - 1; // Index for string a
        int j = b.length() - 1; // Index for string b

        // Iterate over both strings from end to start
        while (i >= 0 || j >= 0) {
            int sum = carry; // Start with carry
            
            // Add corresponding bit from string a if available
            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Convert char to int and add
            }
            
            
            // Add corresponding bit from string b if available
            if (j >= 0) {
                sum += b.charAt(j--) - '0'; // Convert char to int and add
            }
            
            
            // Update the carry
            carry = sum / 10; // sum / 2 gives the carry
            
            // Append the current bit (0 or 1) to the result
            result.append(sum % 10); // sum % 2 gives the bit at the current position
        }
        
        // If there's a carry left, append it
        if (carry != 0) {
            result.append(carry);
        }

        // Reverse the result to get the correct order
        return result.reverse().toString();
    }
}



// Overflow for large inputs : 
/*
        long sum = 0;
        long sum2 = 0;
        for(char c : num1.toCharArray())
        {
            sum = c-'0' + sum*10;
        }
        for(char c1 : num2.toCharArray())
        {
            sum2 = c1-'0' + sum2*10;
        }

        long res = sum+sum2;

        String ans = String.valueOf(res);
        return ans;
      
    }
}

*/