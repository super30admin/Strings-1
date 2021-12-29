// Time Complexity : O(n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        if(s.length() == 0){
            return 0;
        }
        int maxlen = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j = 0; j < s.length(); j++){
            Character c = s.charAt(j);
            if(map.containsKey(c)){
                i = Math.max(i, map.get(c)+1);
            }
                map.put(c, j);
                maxlen = Math.max(maxlen, j - i + 1);
            }        
        return maxlen;
    }
}