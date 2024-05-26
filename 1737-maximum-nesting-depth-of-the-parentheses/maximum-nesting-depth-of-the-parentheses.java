class Solution {
    public int maxDepth(String s) {


// Using Stack :


        int count = 0;
        int maxi = 0;

        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray())
        {
            
            if(c=='(')
            {
                st.push(c);
                count++;
                maxi=Math.max(count,maxi);
            }
            if(!st.isEmpty() && c==')')
            {
                st.pop();
                count--;
            }


        }
       return maxi;

        
    }
}


/*
    int currentDepth = 0;
    int maxDepth = 0;
     for (char c : s.toCharArray()) {
        if (c == '(') {
            // Increase the depth
            currentDepth++;
            // Update the maximum depth
            maxDepth = Math.max(maxDepth, currentDepth);
        } else if (c == ')') {
            // Decrease the depth
            currentDepth--;
        }
    }

    return maxDepth;
    }
}
*/