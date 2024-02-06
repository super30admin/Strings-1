/*
* Approach:
*  1. Maintain two pointers, start and end.
    increment end and include characters into window and
         keep track of repititions using hashset.
* 
*  2. If char is found in hashset,
        increment start till char found is removed from hashset.
    everytime take the max length.
*
*  3. finally, return the max length.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2n)
    n - len of string
* 
* Space Complexity: O(26) == O(1)
* 
*/
import java.util.HashSet;

public class LongestSubstringHashset {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals(""))
            return 0;

        HashSet<Character> hset = new HashSet<Character>();

        int start = 0, end = 0;

        int maxlength = 0;

        while (end < s.length()) {
            char ch = s.charAt(end);

            if (hset.contains(ch)) {
                while (start <= end && s.charAt(start) != ch) {
                    hset.remove(s.charAt(start));
                    start++;
                }
                start++;
            }

            hset.add(ch);
            maxlength = Integer.max(maxlength, end - start + 1);
            end++;
        }

        return maxlength;
    }
}