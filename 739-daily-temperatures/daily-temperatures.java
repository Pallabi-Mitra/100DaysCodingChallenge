class Solution {
    public int[] dailyTemperatures(int[] temps) {

      /* 

       
        int n = temperatures.length; // length of array
        int[] result = new int[n]; // will have the days
        int[] stack = new int[n]; // Using array as a stack
        int top = -1; // Index of the top element in the stack
        
        for (int i = 0; i < n; i++) { // looping for all the temp given in the array
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) { // stack not empty and temp is more than current temp value index stored in the stack

               // int index = stack[top--]; // Pop the top element from the stack
               int index = stack[top]; // warmer day present so we get the index of the immediate prev day for the comparison. so pop index
               top--;
                result[index] = i - index; // Calculate the days until a warmer temperature, store it as result
            }
         //   stack[++top] = i; // Push the current index onto the stack

         // if lesser temp found just add the indexes of it in the stack not get inside while
         top++;
         stack[top] = i;
         
        }
        
        return result;
         }
}
      */
      
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }
}  
        
        /* Bruteforce : O(n2)


         int n = temperatures.length;
        int res[]=new int[n];

        for(int i = 0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(temperatures[j]>temperatures[i])
                {
                    res[i]=j-i;
                    break;
                }
                else
                {
                    res[i]=0;
                }
                
                 

            }
            
        }
        return res;


    }
}

*/
   