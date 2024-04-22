class Solution {
    public int[] intersection(int[] arr1, int[] arr2) {

// Using HashSet :


    int i;
    Set <Integer> set = new HashSet<>();
    ArrayList<Integer> result = new ArrayList<>();

    for (int num1 : arr1) {
            set.add(num1);
        }  

    
    for(int num2 : arr2)
    {
        if(set.contains(num2))
        {
            result.add(num2);
            set.remove(num2);


        }
    }    

/*
    int s = result.size();
    Integer a[]=new Integer[s];
    a=result.toArray(a);

    return a;
*/


int n = result.size();
        int[] PrimitiveArr = new int[n];
        for(i=0; i<n; i++) {
            PrimitiveArr[i] = result.get(i);
        }

return PrimitiveArr;

/*  Using TreeSET :


        Set<Integer> s1 = new TreeSet<>();
         Set<Integer> s2 = new TreeSet<>();
        Set<Integer> result = new TreeSet<>();



          int i,j;

          for(i=0;i<arr1.length;i++)
          {
            s1.add(arr1[i]);
          }
          
          for(i=0;i<arr2.length;i++)
          {
            s2.add(arr2[i]);
          }
          int n = s1.size();
          int m = s2.size();


          while(i<n && j<m)
          {
            if(s1.contains(i)<s2.contains(j))
            {
                i++;
            }
            if(s1.contains(i)>s2.contains(j))
            {
                j++;
            }
            else
            {
                result.add(s1.get(i));
                j++;
                i++;
            }
          }


            int s = result.size();

            int a[]=new int[n];
             a = result.toArray(a); 

    return a;

*/
/*
// 2 Sorted Array : Optimal
        int m = arr1.length;
        int n = arr2.length;
       
       // ArrayList<Integer> arr3 = new ArrayList<Integer>();
        int i = 0, j = 0,k=0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else {
               arr3.add(arr2[j]);
                i++;
                j++;
               
            }

           
        }
/*
        Integer[] arr = new Integer[arr3.size()];
        arr = arr3.toArray(arr);


     return arr;
        */


    }
}