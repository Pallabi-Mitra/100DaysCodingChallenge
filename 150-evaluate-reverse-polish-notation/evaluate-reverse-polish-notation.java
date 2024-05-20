/*

class Solution {
    public int evalRPN(String[] tokens) {


        Stack<Integer> st = new Stack<>();


        for(String c : tokens)
        {
            
        if(!st.isEmpty() && (c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")))
                {
                        int n1 = (int)st.pop();
                        int n2 = (int)st.pop();
                
                    
                        if(c.equals("+"))
                        {
                            st.push(n1+n2);
                        }
                        else if(c.equals("-"))
                        {
                            st.push(n2-n1);
                        }
                        else if(c.equals("*"))
                        {
                            st.push(n1*n2);
                        }
                    else 
                        {
                            st.push(n2/n1);
                        }
                }
                else
           
           st.push(Integer.parseInt(c));
        }

        return st.peek();

        
    }
}

*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String str : tokens){
            if(str.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(a+b);
            } else if(str.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            } else if(str.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a*b);
            } else if(str.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            } else {
                st.push(Integer.parseInt(str));
            }
        }
        return st.peek();
    }
}