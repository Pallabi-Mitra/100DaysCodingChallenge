class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {


 

 Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 and fill the next greater map
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Fill the result array for nums1 using the next greater map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
    

  // Using only hashmap :
  /*  
    HashMap<Integer,Integer> n=new HashMap<Integer,Integer>();

    for(int i=0;i<nums2.length;i++){ // putting all the values of num2 along with the indexes
         n.put(nums2[i],i);     // in the hashmap
                }

    for(int j=0;j<nums1.length;j++){// going through array1
        int v=n.get(nums1[j]);// getting index of the array1 ele from map
         if(v==nums2.length-1){// if the index is last ele of array2
        nums1[j]=-1;//just put -1
        }
        //else :
       for(int k=v+1;k<nums2.length;k++){ // from 1 index ahead in nums2 check for the next greater element
            if(nums2[v]<nums2[k]){// if found a greater element put that in nums1
                  nums1[j]=nums2[k];// for that num1 ele position index
                break;//stop looking
           }
              else{ // if no greater element found put -1
            nums1[j]=-1;
            }
       }
       
     
    }
 
 
    return nums1;
}
}
*/


        // Bruteforce :
/*

        int n1 = nums1.length;
        int n2 = nums2.length;
        Stack<Integer> st = new Stack<>();
        int res1[]=new int[n2];
        int res2[]=new int[n1];

        for(int i = n2-1;i>=0;i--)
        {
           
            while(!st.isEmpty() && st.peek()<nums2[i])
            {
                st.pop();
            }

            
            
                if(st.isEmpty()==false)
                {
                    res1[i]=st.peek();
                }
                else
                {
                    res1[i]=-1;
                }
                st.push(nums2[i]);
        }

            
          for(int i = 0;i<n1;i++)
          {
            for(int j = 0;j<n2;j++)
            {
                 if(nums1[i]==nums2[j])
                 {
                        res2[i]=res1[j];
                 }
            }
           
            
          }  

        return res2;


 */