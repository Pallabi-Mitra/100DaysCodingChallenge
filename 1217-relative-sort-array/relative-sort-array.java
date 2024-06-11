class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sorted = new ArrayList<>();
        
        // Step 1: Build map with indices of elements in arr2
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        
        // Step 2: Iterate arr1 to sort elements based on arr2
        for (int num : arr1) {
            sorted.add(num);
        }
        
        // Step 3: Sort elements in arr1 based on arr2
        Collections.sort(sorted, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (map.containsKey(a) || map.containsKey(b)) {
                    return map.getOrDefault(a, 1001) - map.getOrDefault(b, 1001);
                }
                return a - b;
            }
        });
        
        // Convert sorted list to array
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sorted.get(i);
        }
        
        return arr1;
    }
}