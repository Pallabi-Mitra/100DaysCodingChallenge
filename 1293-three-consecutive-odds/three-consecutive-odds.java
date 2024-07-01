class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {


        int first = 0;
        int second = 1;
        int third = 2;

    int n = arr.length;

    if(n<3)
        return false;

        while(first < n && second < n && third < n)
        {
            if(arr[first]%2!=0 && arr[second]%2!=0 && arr[third]%2!=0)
            {
                return true;
                
            }
            first++;
            second++;
            third++;
        }

        return false;
    }
}