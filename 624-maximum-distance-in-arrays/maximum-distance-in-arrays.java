class Solution {
    public int maxDistance(List<List<Integer>> arrays) {


/*
        int minFinal = Integer.MAX_VALUE;
        int maxFinal = Integer.MIN_VALUE;
        

        int m = arrays.size();

        for(List<Integer> al : arrays) // Outer loop to iterate through the list of lists
        {
             int min1 = Integer.MAX_VALUE;
             int max1 = Integer.MIN_VALUE;

            for(Integer element : al) // Inner loop to iterate through each element in the inner list
            {
               if(element > max1)
               {
                max1= element;
               }
               if(element < min1)
               {
                min1 = element;
               }
            }

            minFinal = Math.min(minFinal,min1);
            maxFinal= Math.max(maxFinal,max1);


        }

        return Math.abs(maxFinal-minFinal);
    }

    */

    // Initialize result to store the maximum distance found
        int result = 0;
        
        // Initialize min_value and max_value using the first array
        int min_value = arrays.get(0).get(0);
        int max_value = arrays.get(0).get(arrays.get(0).size() - 1);
        
        // Traverse from the second array onwards
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);
            
            // Calculate the distance considering global min and max with current array's extremes
            result = Math.max(result, Math.abs(currentMax - min_value));
            result = Math.max(result, Math.abs(max_value - currentMin));
            
            // Update global min and max for the next iteration
            min_value = Math.min(min_value, currentMin);
            max_value = Math.max(max_value, currentMax);
        }
        
        // Return the maximum distance found
        return result;
    }
}