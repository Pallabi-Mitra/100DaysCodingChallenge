class Solution {
    public int calPoints(String[] operations) {

        Stack <Integer> s = new Stack<>();

        for(String op : operations)
        {
            if(op.equals("C"))
            {
                
                
                         s.pop();
               

            }
            else if(op.equals("D"))
            {

                        
                        s.push(2* s.peek());
                
            }

            else if(op.equals("+"))
            {
                
                    
                        int last =  s.pop();
                        int newVal = last + s.peek(); // second last
                     s.push(last);
                s.push(newVal);
                        
                
            }
            else
            {
                
                s.push(Integer.parseInt(op));
            }
        }

        int total = 0;
        for (int score : s) total += score;
        return total;
        
    }
}