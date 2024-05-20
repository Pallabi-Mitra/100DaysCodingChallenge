class Solution {
    public int calculate(String s) {

//Brute force :

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
   /*    
        int result = 0;
        int lastNumber = 0;
        int currentNumber = 0;
        char operation = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                if (operation == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (operation == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                
                operation = currentChar;
                currentNumber = 0;
            }
        }
        
        result += lastNumber;
        return result;
    }
}

   */