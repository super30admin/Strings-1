package Strings1;
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int low = 0;
            int ans = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    low = Math.max(low, map.get(c));
                }
                map.put(c, i+1);
                ans = Math.max(ans, i-low+1);
            }
            return ans;
        }
    }
}
