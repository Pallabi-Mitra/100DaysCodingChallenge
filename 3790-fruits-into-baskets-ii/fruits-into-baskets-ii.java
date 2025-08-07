class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {


/*
        int n = fruits.length;
        
        int count = n;

        for(int i=0;i<n;i++)
        {
                for(int j=0;j<n;j++)
                {
                    if(fruits[i]<=baskets[j] && baskets[j]!=-1)
                    {
                        baskets[j]=-1;
                        count--;
                        break;
                    }
                }
        }

        return count;

        */

        
        int n = fruits.length;
        TreeSet<Integer> available = new TreeSet<>(); // holds indices of available baskets

        // Use TreeMap to map index -> capacity
        Map<Integer, Integer> basketCapacities = new HashMap<>();
        for (int i = 0; i < n; i++) {
            available.add(i); // store basket index
            basketCapacities.put(i, baskets[i]);
        }

        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int index : available) {
                if (basketCapacities.get(index) >= fruits[i]) {
                    available.remove(index); // mark as used
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplaced++;
            }
        }

        return unplaced;
    }
}

   
