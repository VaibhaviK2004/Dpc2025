import java.util.*;

public class CountSubstringsKDistinct {
    
    // Function to count substrings with at most K distinct characters
    public static int countAtMostKDistinct(String s, int k) {
        int n = s.length();
        int left = 0, count = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // Shrink window if more than k distinct characters
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            // Number of substrings ending at right index
            count += (right - left + 1);
        }
        return count;
    }

    // Function to count substrings with exactly K distinct characters
    public static int countExactlyKDistinct(String s, int k) {
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;
        System.out.println(countExactlyKDistinct(s, k)); // Output: 7
    }
}
