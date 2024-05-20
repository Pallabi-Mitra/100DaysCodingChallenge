class Solution {
    public int calculate(String s) {

// Better : Using Stacks
/*
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                
                operation = currentChar;
                currentNumber = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}
*/





   // Optimal : Single pass
      
        // Initialize variables to keep track of the result, last number, current number, and current operation.
int result = 0;
int lastNumber = 0;
int currentNumber = 0;
char operation = '+'; // Default operation is addition.
        
// Iterate through each character of the input string.
for (int i = 0; i < s.length(); i++) {
    // Get the current character at index 'i'.
    char currentChar = s.charAt(i);
    
    // Check if the current character is a digit.
    if (Character.isDigit(currentChar)) {
        // If it's a digit, update the current number by appending the digit.
        currentNumber = currentNumber * 10 + (currentChar - '0');
    }
    
    // Check if the current character is not a digit and not a whitespace,
    // or if it's the last character of the string.
    if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
        // Process the pending operation based on the last operation encountered.
        if (operation == '+') {
            result += lastNumber; // Add lastNumber to result.
            lastNumber = currentNumber; // Update lastNumber with currentNumber.
        } else if (operation == '-') {
            result += lastNumber; // Add lastNumber to result.
            lastNumber = -currentNumber; // Update lastNumber with negative value of currentNumber.
        } else if (operation == '*') {
            lastNumber = lastNumber * currentNumber; // Perform multiplication.
        } else if (operation == '/') {
            lastNumber = lastNumber / currentNumber; // Perform division.
        }
        
        // Update the current operation with the current character.
        operation = currentChar;
        // Reset the current number for the next number.
        currentNumber = 0;
    }
}

// Add the lastNumber (which might be the result of the last operation) to the final result.
result += lastNumber;
// Return the final result.
return result;

    }
}



   
//Brute force : Using 2 ArrayList
/*
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        
        int n = s.length();
        int i = 0;
        
        while (i < n) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numbers.add(num);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                operators.add(ch);
                i++;
            } else {
                i++; // skip spaces
            }
        }
        
        // Handle * and / first
        for (int j = 0; j < operators.size(); j++) {
            char op = operators.get(j);
            if (op == '*' || op == '/') {
                int left = numbers.get(j);
                int right = numbers.get(j + 1);
                int result = 0;
                
                if (op == '*') {
                    result = left * right;
                } else {
                    result = left / right;
                }
                
                numbers.set(j, result);
                numbers.remove(j + 1);
                operators.remove(j);
                j--; // adjust index after removal
            }
        }
        
        // Handle + and -
        int result = numbers.get(0);
        for (int j = 0; j < operators.size(); j++) {
            char op = operators.get(j);
            int right = numbers.get(j + 1);
            
            if (op == '+') {
                result += right;
            } else {
                result -= right;
            }
        }
        
        return result;
    }
}
*/