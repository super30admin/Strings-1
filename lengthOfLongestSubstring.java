// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Use two pointers left and right to keep track of the substring.
 * 2. Use a hashmap to keep track of the characters and their frequency.
 * 3. If the character is already present in the hashmap, move the left pointer to the next index of the character.
 * 4. Update the result with the maximum of the current result and the difference between the right and left pointers.
 * 5. Return the result.
 */

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;

        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}