// Time Complexity : O(N) 
// Space Complexity : O(26)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap();
        
        int start = 0, max = 0;
        
        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if(map.containsKey(ch)) {
                start = Math.max(start, map.get(ch));
            }
            map.put(ch, end + 1);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
