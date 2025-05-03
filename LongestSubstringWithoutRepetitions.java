// Time Complexity : O(n) where n = len of s
// Space Complexity : O(1) where m = no of ASCII characters is constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use a sliding window with two pointers (slow and i).
//   - Use a HashSet to keep track of characters in current window without duplicates.
//   - When duplicate is found, shrink window from left until duplicate is removed.
//   - At each step, update max length of substring.


import java.util.HashSet;

public class LongestSubstringWithoutRepetitions {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int n = s.length();
        int max = 0;
        HashSet<Character> hset = new HashSet<>();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(hset.contains(c)) {
                //move slow and all characters till before ith char
                while(s.charAt(slow) != c) {
                    hset.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            hset.add(c);
            max = Math.max(max, i - slow + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepetitions solution = new LongestSubstringWithoutRepetitions();

        String input1 = "abcabcbb";
        String input2 = "bbbbb";

        System.out.println("Input: " + input1 + " → Output: " + solution.lengthOfLongestSubstring(input1)); // Expected: 3
        System.out.println("Input: " + input2 + " → Output: " + solution.lengthOfLongestSubstring(input2)); // Expected: 1
    }
}
