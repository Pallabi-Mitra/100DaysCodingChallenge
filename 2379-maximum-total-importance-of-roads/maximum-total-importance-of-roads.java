class Solution {
    public long maximumImportance(int n, int[][] roads) {

        // Step 1: Count the number of roads each city is connected to
        int[] roadCount = new int[n];
        for (int[] road : roads) {
            roadCount[road[0]]++;
            roadCount[road[1]]++;
        }

        // Step 2: Pair each city with its road count and sort by the number of roads
        Integer[] cities = new Integer[n];
        for (int i = 0; i < n; i++) {
            cities[i] = i;
        }
        Arrays.sort(cities, Comparator.comparingInt(city -> -roadCount[city]));

        // Step 3: Assign the highest values to the most connected cities
        int[] cityValues = new int[n];
        for (int i = 0; i < n; i++) {
            cityValues[cities[i]] = n - i;
        }

        // Step 4: Calculate the total importance
        long totalImportance = 0;
        for (int[] road : roads) {
            totalImportance += cityValues[road[0]] + cityValues[road[1]];
        }

        return totalImportance;
        
    }
}