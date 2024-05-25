class Solution {
    public String addBinary(String a, String b) {


StringBuilder result = new StringBuilder();
    int carry = 0;
    
    // Start adding digits from the least significant digit (rightmost)
    int i = a.length() - 1;
    int j = b.length() - 1;
    
    // Continue adding digits until both numbers are fully processed
    while (i >= 0 || j >= 0 || carry > 0) {
       int sum=carry;
        

         if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int and add
                i--;
            }
            
            
            // Add corresponding bit from string b if available
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int and add
                j--;
            }

       
        
       
        
        // Update carry for the next iteration
        carry = sum / 2;
        
        // Append the least significant digit of the sum to the result
        result.append(sum % 2);
        
    }
    
    // Reverse the result since we appended digits from least significant to most significant
    return result.reverse().toString();
    }
}




// Optimal Approach :
/*

StringBuilder result = new StringBuilder(); // To store the result
        int carry = 0; // Initialize carry to 0
        int i = a.length() - 1; // Index for string a
        int j = b.length() - 1; // Index for string b

        // Iterate over both strings from end to start
        while (i >= 0 || j >= 0 || carry>0) {
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
            carry = sum / 2; // sum / 2 gives the carry
            
            // Append the current bit (0 or 1) to the result
            result.append(sum % 2); // sum % 2 gives the bit at the current position
        }
        
        // If there's a carry left, append it
        //if (carry != 0) 
            //result.append(carry);
        

        // Reverse the result to get the correct order
        return result.reverse().toString();
    }




}

*/















// Bruteforce : runtime Error for large input size:
/*

    int num1 =Integer.parseInt(a,2); // Decimal representation
    int num2 = Integer.parseInt(b,2);

    int sum = num1+num2;

    return Integer.toBinaryString(sum);
        
    }
}
*/