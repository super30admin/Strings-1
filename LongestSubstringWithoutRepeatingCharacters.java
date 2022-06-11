// Time Complexity : O(N), N = string length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // s = s.trim();
            if (s.length() == 0) return 0;
            if(s.length() == 1) return 1;
            int output = 0;
            int l=0;
            int r =0;
            int[] chars = new int[128];
            for(r = 0; r< s.length();r++){
                chars[s.charAt(r)] +=1;
                while(chars[s.charAt(r)] > 1) {
                    chars[s.charAt(l)]  -=1;
                    l+=1;
                }
                output = Math.max(output,r-l+1);
            }
            return output;
        }
    }
}
