class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

        List<int[]> ans = new ArrayList<>();

        for(int i=0;i<restaurants.length;i++)
        {
            int id = restaurants[i][0];
            int rating = restaurants[i][1];
            int vf=restaurants[i][2];
            int price = restaurants[i][3];
            int distance = restaurants[i][4];

            if(veganFriendly==1)
            {
                if(vf==1 && price <= maxPrice && distance <= maxDistance )
                {
                    ans.add(new int[]{id,rating});
                }
            }
            else
            {
                 if(price <= maxPrice && distance <= maxDistance )
                 {
                    ans.add(new int[]{id,rating});
                 }
            }

        }
        //sort

        
        Collections.sort(ans,(a,b)->{

            if(b[1]!=a[1])
                return b[1]-a[1]; // sort by rating descending
            else
                return b[0]-a[0];// Compare by id descending if ratings are equal
        });
            

        //extract only id

        List<Integer> result = new ArrayList<>();

        for(int[] a : ans)
        {
            result.add(a[0]);
        }


        return result;
        
    }
}