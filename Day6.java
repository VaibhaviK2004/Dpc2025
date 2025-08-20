import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findSubarraysWithZeroSum(int[] arr) {
        List<int[]> result = new ArrayList<>();
        int prefixSum = 0;
        
        // Map stores prefix sum and list of indices where it occurs
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1))); // Handle subarrays starting at index 0

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (sumMap.containsKey(prefixSum)) {
                for (int startIndex : sumMap.get(prefixSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            sumMap.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> subarrays = findSubarraysWithZeroSum(arr);

        for (int[] subarray : subarrays) {
            System.out.println("Subarray found from index " + subarray[0] + " to " + subarray[1]);
        }
    }
}
