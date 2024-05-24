class Solution {
    public String addStrings(String num1, String num2) {

// Addition Digit by Digit :


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