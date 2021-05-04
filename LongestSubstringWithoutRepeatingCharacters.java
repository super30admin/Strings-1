// Time Complexity : O(N)
// Space Complexity : O(256) = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int slow = 0;
        int result = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>(256);
        for(int fast = 0 ; fast < s.length() ;fast++){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c)+1);
            }
            result = Math.max(result,fast-slow+1);
            map.put(c,fast);
        }
        return result;
    }
}
