/*
class MinStack {

Stack<Integer> stack;
int min;
 
      
    public MinStack() {
       
    

    stack = new Stack<>();
    min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        // If val is less than or equal to the current minimum, push the current minimum first
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
        
    }
    
    public void pop() {
         if(stack.pop()==min)
            min=stack.pop();
        
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
}
*/
class MinStack {
    class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    Node head;

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        int min = head == null ? val : Math.min(val, head.min);
        head = new Node(val, min, head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */