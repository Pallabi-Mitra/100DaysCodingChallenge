class Solution {
    public int minOperations(String[] logs) {

      // Using Stack :

      /*
      
        Stack<String> stack = new Stack<>();
    
    for (String log : logs) {
        if (log.equals("../")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else if (!log.equals("./")) {
            stack.push(log);
        }
    }
    
    return stack.size();

        
    }
}

*/

    // Using counter :

    int depth = 0;
    
    for (String log : logs) {
        if (log.equals("../")) {
            if (depth > 0) {
                depth--;
            }
        } else if (!log.equals("./")) {
            depth++;
        }
    }
    
    return depth;
}
}