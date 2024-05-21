class Solution {
    public String removeKdigits(String num, int k) {

        if(k>=num.length()) return "0";

        Stack<Character> st = new Stack<>();
        for(char c : num.toCharArray())
        {
            while(!st.isEmpty() && st.peek()>c && k>0)
            {
                k--;
                st.pop();
            }


            st.push(c);
        }

        while(k>0)
        {
            st.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();

        while(!st.isEmpty())
        {
            result.append(st.pop());

        }
        result.reverse();

        while(result.length()>0 && result.charAt(0)=='0')
        {
            result.deleteCharAt(0);
        }

        return result.length()==0? "0" : result.toString();

        
    }
}