class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {

         // Step 1: Create a custom comparator for sorting
        Comparator<Integer> comparator = (a, b) -> {
            int mappedA = getMappedValue(a, mapping);
            int mappedB = getMappedValue(b, mapping);
            return Integer.compare(mappedA, mappedB);
        };
        
        // Step 2: Convert the array to a list for sorting
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        // Step 3: Sort using the custom comparator
        Collections.sort(list, comparator);
        
        // Step 4: Convert the list back to an array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        
        return nums;
    }
    
    private int getMappedValue(int num, int[] mapping) {
        String numStr = Integer.toString(num);
        StringBuilder newNumStr = new StringBuilder();
        
        for (char ch : numStr.toCharArray()) {
            newNumStr.append(mapping[ch - '0']);
        }
        
        return Integer.parseInt(newNumStr.toString());
    }
}