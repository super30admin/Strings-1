// Time Complexity :
// Space Complexity :  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * 3. Longest Substring Without Repeating Characters
 * 
 * When ever there are nested iterations that lead to O(n^2); below should be looked into
 * - Two pointer approach
 * - Sliding window
 * - Hashing
 * 
 * 
 */

import java.util.*;

public class LongestSubstringWithoutRepeat {

    /*
     * Using Hashmap ; sliding window
     * Time complexity: O(n)
     * Space complexity:O(1) ; since there are only 26 characters in English
     * 
     * Have a slow pointer: helps find the length of the substring without repeating
     * characters
     * 
     * As we go through the length of the given string, put the character and index
     * in a map.
     * If at any point during treversal of string we find a matching key (character)
     * then move our slow pointer to index (if index is greater than the current
     * slow)+1
     * 
     * Note: Donot forget to add +1 to result since we are manipulating on indexes
     * and we are outputing length.
     */
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> indexCache = new HashMap<>();
        int result = 0;
        int slow = 0; // start of window

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexCache.containsKey(c)) {
                slow = Math.max(indexCache.get(c) + 1, slow); // slow cannot be less than the current slow, covers the
                                                              // scenario where we already passed a character
            }
            indexCache.put(c, i);
            result = Math.max(result, i - slow + 1); // do not forget to add +1 as its length not index.
        }

        return result;

    }

    /*
     * Using Two pointer ; sliding window
     * Time complexity: O(2n)
     * Space complexity:O(1) ; since there are only 26 characters in English
     * 
     * We have a slow pointer starting 0; as i moves forward we add it to set and if
     * at any point we find a character thats already visited in string prev..
     * in a while loop make the slow reach to that point so we can calculate the
     * length at that window. (Dynamic window)
     * 
     * Note: Donot forget to add +1 to result since we are manipulating on indexes
     * and we are outputing length.
     */
    public int lengthOfLongestSubstring_2(String s) {

        int slow = 0;
        int result = 0;
        Set<Character> cache = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cache.contains(c)) {

                while (s.charAt(slow) != c) {
                    cache.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            cache.add(c);
            result = Math.max(result, i - slow + 1);
        }

        return result;

    }

}
