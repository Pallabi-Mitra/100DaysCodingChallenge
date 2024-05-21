class Solution {
    public int largestRectangleArea(int[] heights) {
        

// Most Optimal : 
/*
 Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
  
        for (int i = 0; i <= n; i++) {
// calculate the width of the greater stack element before popping it
            while (!stack.isEmpty() && (i==n || heights[stack.peek()]>=heights[i])) {
                int height = heights[stack.peek()];
                stack.pop();
                int width;
            if(stack.isEmpty()) width= i; // if nothing is left smaller its 0, complete width
                else width = i- stack.peek() - 1;
                 // Right smaller - Left Smaller - 1 gives width
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i); // psuh the elements
        }
        return maxArea;
    }
}
*/

        int n = heights.length; // Get the length of the heights array
        int[] left = new int[n]; // Array to store the index of the nearest smaller element to the left
        int[] right = new int[n]; // Array to store the index of the nearest smaller element to the right
       
        // Fill the left array
        for (int i = 0; i < n; i++) {
            int j = i - 1; // Start checking from the element to the left of i
            while (j >= 0 && heights[j] >= heights[i]) {
                // Move left to find the nearest smaller element
                j = left[j];
            }
            left[i] = j; // Store the index of the nearest smaller element
        }

        // Fill the right array
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1; // Start checking from the element to the right of i
            while (j < n && heights[i] <= heights[j]) {
                // Move right to find the nearest smaller element
                j = right[j];
            }
            right[i] = j; // Store the index of the nearest smaller element
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            // Calculate the width of the rectangle
            int curArea = heights[i] * (right[i] - left[i] - 1);
            // Update maxArea if the current area is larger
            maxArea = Math.max(maxArea, curArea);
        }
        
        return maxArea; // Return the maximum area found
    }
}



 //Better Approach :  Using 2 arrays and 1 stack :

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