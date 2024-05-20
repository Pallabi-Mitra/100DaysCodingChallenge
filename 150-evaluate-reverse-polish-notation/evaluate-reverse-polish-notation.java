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