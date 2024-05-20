class Solution {
   




   // Using Recursion :

    int idx; // this index traverse the string in one pass, between different level of recursion
    public int calculate(String s) {
        idx = 0; // Initialization should be here
        return calc(s);
    }
    
    private int calc(String s) {
        int res = 0, num = 0, sign = 1;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            else if (c == '(') num = calc(s); // ( is start of a new sub-problem, Let recursion solve the sub-problem
            else if (c == ')') return res + sign * num;
            else if (c == '+' || c == '-') { // only when we meet a new sign, we know a while number has been read
                res += sign * num;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        return res + sign * num; // last number is not processed yet
    }
}

    // Using Stack :

    /*
    
    public int calculate(String s) {
        int num = 0;
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        
        result += sign * num;
        
        return result;
    }
}

*/
        
    
