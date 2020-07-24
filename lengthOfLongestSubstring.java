// Time Complexity : O(n) n is string length
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length()==0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int maxLength = 1;
        int i=0;
        while(i<s.length())
        {
            if(map.containsKey(s.charAt(i)))
            {
                maxLength = Math.max(maxLength,map.size());
                i=map.get(s.charAt(i));
                map = new HashMap<>();
            }
            else
            {
                map.put(s.charAt(i),i);
                
            }
            i++;
        }
        maxLength = Math.max(maxLength,map.size());
        return maxLength;
    }
}