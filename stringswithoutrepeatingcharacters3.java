// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c)+1);
            }
            map.put(c, i);
            max = Math.max(max, i-slow+1);
        }
        return max;
    }
}
