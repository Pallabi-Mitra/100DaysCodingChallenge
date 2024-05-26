class Solution {
    public int maxDepth(String s) {

        int count = 0;
        int maxi = -1;

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
       return maxi == -1 ? 0 : maxi;

        
    }
}