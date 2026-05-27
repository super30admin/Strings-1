// Time Complexity : O(n) where n is the length of the input string s.
// Space Complexity : O(26) which is O(1) since we are only storing the frequency of characters in the input string s.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Create a HashSet to store the unique characters in the current substring.
// 2. Iterate through the input string s and for each character, check if it exists in the HashSet. If it does, remove characters from the left pointer until the duplicate character is removed from the HashSet.
// 3. Add the current character to the HashSet and update the maximum length of the substring without repeating characters by calculating the size of the HashSet.
// 4. Finally, return the maximum length of the substring.
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.equals("")) return 0;

        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            max = Math.max(max, set.size());
        }

        return max;
    }
}