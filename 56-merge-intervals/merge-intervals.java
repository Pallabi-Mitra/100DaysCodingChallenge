
// ask first if the intervals given are in sorted or not : 

class Solution {
    public int[][] merge(int[][] arr) {

        List<int[]> res = new ArrayList<>();

        if(arr.length==0 || arr==null)
        {
            return res.toArray(new int[0][]);
        }

        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        int start = arr[0][0];
        int end = arr[0][1];


        for(int[] i : arr)
        {
            if(i[0] <= end) // overlapping- start of next is less than prev end
            {
                end = Math.max(end, i[1]); // merging - taking max end
            }
            else // not merging so add normally
            {
                res.add(new int[]{start,end});
                start=i[0]; // reassign the intervals 
                end = i[1];
            }
        }


        res.add(new int[]{start,end});

        return res.toArray(new int[0][]);



    }
}
        
        // Optimal, 2D Array:

        /*

        class Solution {
    public int[][] merge(int[][] arr) {
        
        int n = arr.length;
         List<int []> ans = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0],b[0]));

        ans.add(arr[0]);

        for(int i = 1;i<n;i++)
        {
             int temp[]=new int[2];

             if(ans.get(ans.size()-1)[1] >= arr[i][0])
             {
                temp[0]= Math.min(ans.get(ans.size()-1)[0],arr[i][0]);
                temp[1]= Math.max(ans.get(ans.size()-1)[1],arr[i][1]);
                //ans.add(temp);
                ans.set(ans.size()-1,temp);
             }
             else
             {
                    ans.add(arr[i]);
             }
        }

            return ans.toArray(new int[ans.size()][]);


        }

    }
    */

       /*
       // optimal : TC: O(n log n )+ O(n) : Using return list

       List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1) )
            {
                ans.add(arr[i]); // new interval forms
            }

            else
            {
              ans.get(ans.size() - 1).set(1,Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }

       return ans;
    }
}
*/

// Bruteforce : TC :  O(n log n) + O(2n), SC : O(n)
/*
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) { // select an interval:
            int start = arr[i][0];
            int end = arr[i][1];

            //Skip all the merged intervals:
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            //check the rest of the intervals:
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }

     //  return ans.toArray(new int[ans.size()][]);
     return ans;


    }
}
*/