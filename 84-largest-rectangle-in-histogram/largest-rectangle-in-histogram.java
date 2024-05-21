class Solution {
    public int largestRectangleArea(int[] heights) {
        


        // Using 2 arrays and 1 stack :
/*

        int n =heights.length;

        Stack<Integer> st = new Stack<>();

        int leftSmall[]=new int[n]; // store left smaller index
        int rightSmall[]=new int[n]; // store right smaller index


        for(int i = 0;i<n;i++)
        {
            //if stack has index corresponding to greater value pop it
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){ 
                
                st.pop();
            }
        // if stack goes empty popping all greater elements means no one is smaller put 0(leftmost possible as boundary)
            if(st.isEmpty())
            {
                leftSmall[i]=0;
            }
            else// whatever index is at top +1 will be the boundary
            {
                leftSmall[i]=st.peek()+1;
            }

            st.push(i); // push the index of current always at last
        }

        // clear the stack to reuse again :

        while(!st.isEmpty()) st.pop();

        for(int i=n-1;i>=0;i--)
        {
             while(!st.isEmpty() && heights[st.peek()]>=heights[i]){ 
                
                st.pop();
            }
// stack is empty no element is small, then rightmost possible index is boundary, which is    len of array-1
             if(st.isEmpty())
            {
                rightSmall[i]=n-1; 
            }
            else// whatever index is at top - 1 will be the boundary
            {
                rightSmall[i]=st.peek()-1;
            }

            st.push(i); // push the index of current always at last


        }

        int maxArea=0;

        for(int i = 0;i<n;i++)
        {
            maxArea = Math.max(maxArea,((rightSmall[i]-leftSmall[i]+1) * heights[i]));
        }

        return maxArea;



    }
}

*/

// Bruteforce - TLE
/*
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                maxArea = Math.max(maxArea, minHeight * width);
            }
        }
        return maxArea;
    }

}
*/
/*
 Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
  
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i==n || heights[stack.peek()]>=heights[i])) {
                int height = heights[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()) width= i;
                else width = i- stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
*/


        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        // left[0] 和 right[n - 1] 會是 -1

        for(int i = 0; i < n; i++) {
            int j = i - 1;
            while(j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }

        for(int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while(j < n && heights[i] <= heights[j]) {
                j = right[j];
            }
            right[i] = j;
        }

        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int curArea = heights[i] * (right[i] - left[i] - 1);
            maxArea = Math.max(maxArea, curArea);
        }
        
        return maxArea;
    }
}