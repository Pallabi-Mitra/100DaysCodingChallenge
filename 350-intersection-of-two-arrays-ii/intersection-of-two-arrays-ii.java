class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {


// HashMap

        // Step 1: Create a frequency map for nums1
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Find intersection using nums2
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        // Step 3: Convert list to array
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }
        
        // Step 4: Return the intersection array
        return intersection;
    }
}
// better :
/*

        // Step 1: Sort both input arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // Step 2: Initialize variables
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        
        // Step 3: Iterate through sorted arrays using two pointers
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // Found intersection, add to result list
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                // Move pointer of nums1 to the right
                i++;
            } else {
                // Move pointer of nums2 to the right
                j++;
            }
        }
        
        // Step 4: Convert list to array
        int[] intersection = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            intersection[k] = result.get(k);
        }
        
        // Step 5: Return the intersection array
        return intersection;
    }
}
*/
// Brute force :
/*
        ArrayList<Integer> al = new ArrayList<>();

        int k =0;
       

        for(int i = 0;i<nums1.length;i++)
        {
            for(int j =0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j] && nums2[j]!=-1)
                {
                    al.add(nums1[i]);
                    nums2[j]=-1;
                    break;
                }
            }
        }
 int res[]=new int[al.size()];
        for(int num : al)
        {
            res[k]=num;
            k++;
        }
        return res;
        
    }
}

*/