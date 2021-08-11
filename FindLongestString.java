// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map= new HashMap<>();
        int start=0, len=0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            len = Math.max(len, i-start+1);
            map.put(c, i);
        }
        return len;
    }
}
