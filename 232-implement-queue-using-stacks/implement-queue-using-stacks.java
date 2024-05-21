class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {

        input = new Stack<>();
        output= new Stack<>(); 
    }
    
    public void push(int x) {

        input.push(x); // keep adding 
        
    }
    
    public int pop() {

        if(!output.isEmpty()) // if data is present
        {
           return output.pop();
        }
        else
        {
                while(!input.isEmpty()) // put all data of input stack to output.
                // this will keep the 1st inserted element at top of output stack
                {
                    output.push(input.peek());
                    input.pop(); // remove from input stack

                    
                }
                return output.pop(); // FIFO maintained. 
        }
        
    }
    
    public int peek() {

        if(!output.isEmpty())
        {
           return output.peek();
        }
        else // output has no data
        {
            while(!input.isEmpty())
            {
                output.push(input.peek()); // put elements of stack 1
                input.pop();

            }
            return output.peek();
        }

        
    }
    
    public boolean empty() {

        return input.isEmpty() && output.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */