public class LongestPalindromeSubstring {
    
    // Function to find the longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // even length palindrome
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    // Expand from the center and return palindrome length
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // Main method for testing
    public static void main(String[] args) {
        String input = "babad";
        System.out.println("Input: " + input);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(input));
    }
}
