class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] newNums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            newNums[i] = nums[i];
        }

        Arrays.sort(newNums, (n1, n2) -> {
            if (freq.get(n1) != freq.get(n2)) {
                // if freq of numbers are not equal then return in increasing order based on
                // freq.
                return freq.get(n1) - freq.get(n2);
            } else {
                // otherwise sort them in decreasing order based on number in nums.
                return n2 - n1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }

        return nums;
    }
}







/*
class Solution {
    public int[] frequencySort(int[] nums) {

// Step 1: Initialize the HashMap
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Step 2: Count frequencies
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: Create a list of the array elements
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Step 4: Sort the list using a custom comparator
        Collections.sort(list, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB); // Sort by frequency
            } else {
                return Integer.compare(b, a); // If frequencies are same, Sort by value in decreasing order
            }
        });

        // Step 5: Convert the list back to an array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;



    }
}

*/
// java 8

/*
        // Step 1: Count the frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the array using a custom comparator
        // Convert the array to Integer[] to use Arrays.sort with a custom comparator
        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(numsArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int freqA = frequencyMap.get(a);
                int freqB = frequencyMap.get(b);
                if (freqA != freqB) {
                    return freqA - freqB; // Sort by frequency in ascending order
                } else {
                    return b - a; // Sort by value in descending order if frequencies are the same
                }
            }
        });

        // Convert Integer[] back to int[]
        return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
        
    }
}

*/