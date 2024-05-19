class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {


        // Bruteforce :


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


        
    }
}