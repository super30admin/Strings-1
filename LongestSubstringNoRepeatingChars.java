/*
 * #3. Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:

Input: s = ""
Output: 0
 

Constraints:

1. 0 <= s.length <= 5 * 104
2. s consists of English letters, digits, symbols and spaces.

 */


/*
 * Time Complexity: O (N) -> To traverse through the characters in a string
 * 
 * Space Complexity: O (N) -> HashMap to store the characters of a string as a key and index where start pointer should go next as a value
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.strings1;

import java.util.HashMap;

public class LongestSubstringNoRepeatingChars {
	public int lengthOfLongestSubstring(String s) {
        
        // #1. Base condition
        if(s == null || s.length() == 0){
            return 0;
        }
        
        // #2. Initialize start pointer, end pointer, and max length of a substring
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        
        // #3. Create a HashMap which will store the character at end pointer as a key and index where start pointer should go next
        HashMap<Character, Integer> map = new HashMap<>();
            
        // #4. Traverse the end pointer to find maximum length of a substring
        // We just check for end pointer as it will go out of bounds before start pointer
        while(end < s.length()){
            // Get the character at end pointer
            char ch = s.charAt(end);
            
            /* #4.1
             * 
            * If map contains character at end pointer -> repeating character,
            * then, before moving start pointer to new index, get max of current start pointer and the index value in a map for that character, that will be the new starting pointer
            * After getting new start pointer, update the index value for character at end pointer in a map to end + 1 -> position of start pointer when that character is encountered again.
            * If map does not contain character at end pointer, put it in a map with index value as end pointer + 1 -> position of start pointer when that character is encountered again.
            * After having a valid start pointer, compute the size of current substring and compare it eith previous max value
            * Increment the end pointer
            * Repeat above steps until end pointer goes out of bounds 
            * Once while loop exits, return the maximum substring length w/o repeating characters
            */
            
            if(map.containsKey(ch)){
                start = Math.max(start, map.get(ch));
            }
            map.put(ch, end + 1);
            max = Math.max(max, end - start + 1);
            
            end++;
        }
        
        return max; // return the maximum length of a substring w/o repeating characters
    } 

}
