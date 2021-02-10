import java.util.HashSet;

// Time Complexity :O(n)
// Space Complexity :O(n), space needed in hashset
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach

public class LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s==null||s.length()==0) return 0;

            int i = 0, j = 0, max =0;
            HashSet<Character> hs = new HashSet<>();//keep track of characters in sliding window

            //implement sliding window
            while(i < s.length()){
                char c = s.charAt(i);
                //check if set contains c
                while(hs.contains(c)){
                    hs.remove(s.charAt(j));
                    ++j;
                }
                hs.add(c);//add char back to hashset
                max = Math.max(max,i-j+1);//compute max
                ++i;
            }
            return max;
        }
    }

}
