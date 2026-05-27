// Time Complexity : O(n) where n is the length of the input string s.
// Space Complexity : O(26) which is O(1) since we are only storing the frequency of characters in the input string s.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Create a HashMap to store the last index of each character in the input string s.
// 2. Iterate through the input string s and for each character, check if it exists
//    in the HashMap. If it does, update the left pointer to the maximum of its current value and the last index of the character + 1.
// 3. Update the last index of the character in the HashMap to the current index.
// 4. Update the maximum length of the substring without repeating characters by calculating the difference between the right and left pointers + 1.
// 5. Finally, return the maximum length of the substring 
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.equals("")) return 0;

        int max = Integer.MIN_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}