package strings1;

/*
Idea : 	1. We start with two pointers : i, j; keep on moving j pointer.
 		2. If hashset doesn't have that element, we add it in, if it gets repeated, 
 		// we remove element at i pointer so as to maintain the non repetitive result number.
 		3. And since all the elements previous to j pointer are in hashset, i pointer keeps on moving ahead till it overlaps j,
 		// and the process is continued for finding new maxlength.
Time Complexity : O(s) where s is number of characters in s string
Space Complexity : O(s) where s is the number of characters in string S (used by hashset).
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        if(s.length() == 0) return 0;
        int i = 0, j = 0;
        while(j < s.length()) {
            if(!hs.contains(s.charAt(j))) {
                hs.add(s.charAt(j));
                 j++;
                maxLen = Math.max(maxLen, (j - i));
               
            }
            else {
               hs.remove(s.charAt(i));
                i++;
                
            }
        }
        return maxLen;
    }

	
}
