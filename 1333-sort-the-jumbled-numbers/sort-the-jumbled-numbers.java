

/*
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

*/
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Step 1: Create a list to store original nums and their mapped values
        List<int[]> mappedList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String s = Integer.toString(nums[i]);
            StringBuilder n = new StringBuilder();
            for (char ch : s.toCharArray()) {
                n.append(mapping[ch - '0']);
            }
            mappedList.add(new int[]{nums[i], Integer.parseInt(n.toString()), i});
        }

        // Step 2: Sort the list based on the mapped values and original indices for stability
        mappedList.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[2], b[2]);
            }
        });

        // Step 3: Create a result array and fill it with the sorted original nums
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < mappedList.size(); i++) {
            sortedNums[i] = mappedList.get(i)[0];
        }

        return sortedNums;
    }
}