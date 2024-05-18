class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>(); // declare stack

        for(char c : s.toCharArray()) // iterate over each character of the string
        {
                if(c=='(' || c=='{' || c=='[') // if opening bracket push in stack
                    st.push(c);

                else // if encountered closing bracket
                {
                    if(st.isEmpty()) // check if stack is empty, if true return false since no pair present, brackets cannot close without having an open bracket from before hand
                        return false;
                   // if stack has elements
                   char top = st.pop(); // take the top one element out

        // when recieved closing bracket its corresponding  open bracket should be present next in stack. If not present we return false
                   if((c==')' && top!='(') || (c=='}' && top!='{') || (c==']' && top!='['))
                        return false;
                }
        }
/*
        if(st.isEmpty())
            return true;
        else
            return false;
*/
return st.isEmpty();

        
    }
}