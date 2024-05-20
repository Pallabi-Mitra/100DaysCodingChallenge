
/*
// class to store the price and it's span in an object
class Pair{
    int price;
    int span;

    public Pair(int e, int c){
        price = e;
        span = c;
    }
}

class StockSpanner {

    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        
        int span = 1;
        
        //For every new price, if the top element in the stack is smaller or
        //equal to the given price then add the top element count + it's own count
        //Keep on doing it untill st.peek() > price
        while(!st.isEmpty() && st.peek().price <= price){
            span += st.peek().span;
            st.pop();
        }
        
        st.push(new Pair(price, span));

        return span;
    }
}
*/
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/*
class StockSpanner {

    public StockSpanner() {
        
    }
    
    public int next(int price) {

       // Bruteforce :


        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

 class StockSpanner {
//    Initialize a stack with int array.
//      First Index would be price, and
//      Second Index Will be span at that price.
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
//        At each level initialize the span to 1.
        int span = 1;
//        If The top element of stack price is below or equal to the current price:
//          Then, the previous element will be span of current.
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            span += stack.pop()[1];
        }
//        At each level add the price and the span. 
//        So that Next time when visited for consecutive days, you have the value of current that will avoid traversal till the current days span. 
        stack.add(new int[]{price, span});
        return span;
    }
}